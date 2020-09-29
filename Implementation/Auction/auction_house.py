import argparse

from Implementation.Auction.auction_function.item import Item

class Auction:
    def __init__(self):
        self.auction_list = {}

    def add_item(self, values):
        auction_item = Item(values)
        # check item existing
        if auction_item.item in self.auction_list.keys():
            print("Item {} exists".format(auction_item.item))
        else:
            self.auction_list[auction_item.item] = auction_item

    def bid_item(self, values):
        timestamp = int(values[0])
        user_id = values[1]
        action = values[2]
        item = values[3]
        bid_amount = float(values[4])

        # Get current item
        current_item = self.auction_list[item]

        if current_item.status != "UNSOLD" and current_item.status != "SOLD":
            # Before closing time
            # Bid validation
            if current_item.validate_bid(timestamp, bid_amount):
                current_item.update_owner(user_id)
                current_item.update_status(action)
                current_item.update_bid_amount(bid_amount)

            current_item.update_lowest_highest(bid_amount)

    def heartbeat_check(self, values):
        timestamp = int(values[0])
        for item_name, item_object in self.auction_list.items():
            if item_object.close_time == timestamp:
                # Auction stops
                if item_object.status == "SELL":
                    # Item unsold
                    item_object.update_status("UNSOLD")
                elif item_object.status == "BID":
                    item_object.update_status("SOLD")

    def main(self, file_path):
        # read input file
        input_file = open(file_path, "r")
        line = input_file.readline()

        while (line):
            values = line.strip().split("|")
            if len(values) == 6:
                # Create Users listing items object for sale.
                self.add_item(values)

            elif len(values) == 5:
                # Bid item
                self.bid_item(values)

            elif len(values) == 1:
                self.heartbeat_check(values)

            # read next line
            line = input_file.readline()

        input_file.close()

        # Print result
        for item_name, item_object in self.auction_list.items():
            if item_object.status == "SOLD":
                print("|".join([str(item_object.close_time), item_name, item_object.current_owner, "SOLD", "%.2f" % round(item_object.last_bid,2),
                                str(item_object.total_valid_bid), "%.2f" % round(item_object.highest_bid, 2), "%.2f" % round(item_object.lowest_bid, 2)]))
            elif item_object.status == "UNSOLD":
                print("|".join([str(item_object.close_time), item_name, "UNSOLD", "0.00",
                                str(item_object.total_valid_bid), "%.2f" % round(item_object.highest_bid, 2), "%.2f" % round(item_object.lowest_bid, 2)]))


if __name__ == '__main__':
    ap = argparse.ArgumentParser()
    ap.add_argument("-f", "--file", required=True,
                    help="path to input file")
    args = vars(ap.parse_args())
    file_path = args["file"]
    auction = Auction()
    auction.main(file_path)