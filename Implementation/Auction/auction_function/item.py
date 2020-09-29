class Item:
    def __init__(self, values):
        self.start_time = int(values[0])
        # self.current_time = int(values[0])
        self.current_owner = values[1]
        self.status = values[2]
        self.item = values[3]
        self.reserve_price = float(values[4])
        self.last_bid = 0
        self.current_bid = 0
        self.close_time = int(values[5])
        self.total_valid_bid = 0
        self.highest_bid = 0 # Highest bid before closing time
        self.lowest_bid = float("inf") # Lowest bid before closing time

    def validate_bid(self, time, bid):
        # Arrives after the auction start time and before or on the closing time.
        # Is larger than any previous valid bids submitted by the user.
        if self.start_time < time <= self.close_time and bid > self.highest_bid:
            # valid bid
            self.total_valid_bid += 1
            if bid >= self.reserve_price:
                # can be sold
                return True
        elif bid == self.last_bid:
            return False
        else:
            return False

    # def update_timestamp(self, time):
    #     self.current_time = time

    def update_owner(self, user_id):
        self.current_owner = user_id

    def update_status(self, action):
        self.status = action

    def update_bid_amount(self, bid_amount):
        self.last_bid = self.current_bid
        self.current_bid = bid_amount

    def update_lowest_highest(self, bid_amount):
        if bid_amount > self.highest_bid:
            self.highest_bid = bid_amount

        if bid_amount < self.lowest_bid:
            self.lowest_bid = bid_amount

