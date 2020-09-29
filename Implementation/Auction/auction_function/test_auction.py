import unittest
from Implementation.Auction.auction_house import Auction
from Implementation.Auction.auction_function.item import Item


class TestAuction(unittest.TestCase):
    def setUp(self):
        self.auction_house = Auction()

    def tearDown(self):
        self.auction_house = None

    def testAddSellItemSuccess(self):
        auction = Item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.assertEqual(self.auction_house.auction_list.keys(), {auction.item: auction}.keys())

    def testAddSellItemFailure(self):
        auction1 = Item([10, 1, "SELL", "toaster_1", 10.00, 20])
        auction2 = Item([11, 1, "SELL", "toaster_1", 12.00, 20])
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.add_item([11, 1, "SELL", "toaster_1", 12.00, 20])
        self.assertEqual(self.auction_house.auction_list.keys(), [auction1.item, auction2.item])

    def testBidItemSuccess1(self):
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.bid_item([13, 5, "BID", "toaster_1", 12.50])
        item = self.auction_house.auction_list["toaster_1"]
        self.assertListEqual([item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
                              item.highest_bid, item.lowest_bid],
                             [5, "BID", 0, 12.50, 1, 12.50, 12.50])

    def testBidItemSuccess2(self):
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.bid_item([12, 8, "BID", "toaster_1", 7.50])
        self.auction_house.bid_item([13, 5, "BID", "toaster_1", 12.50])
        item = self.auction_house.auction_list["toaster_1"]
        self.assertListEqual(
            [item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
             item.highest_bid, item.lowest_bid],
            [5, "BID", 0, 12.50, 2, 12.50, 7.50])

    def testBidItemFailure(self):
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.bid_item([12, 8, "BID", "toaster_1", 7.50])
        item = self.auction_house.auction_list["toaster_1"]
        self.assertListEqual(
            [item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
             item.highest_bid, item.lowest_bid],
            [1, "SELL", 0, 7.50, 1, 7.50, 7.50])

    def testSoldSuccess(self):
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.bid_item([13, 5, "BID", "toaster_1", 12.50])
        self.auction_house.heartbeat_check([20])
        item = self.auction_house.auction_list["toaster_1"]
        self.assertListEqual(
            [item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
             item.highest_bid, item.lowest_bid],
            [5, "SOLD", 0, 12.50, 1, 12.50, 12.50])

    def testSoldFailure(self):
        self.auction_house.add_item([10, 1, "SELL", "toaster_1", 10.00, 20])
        self.auction_house.bid_item([13, 5, "BID", "toaster_1", 2.50])
        self.auction_house.heartbeat_check([20])
        item = self.auction_house.auction_list["toaster_1"]
        self.assertListEqual(
            [item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
             item.highest_bid, item.lowest_bid],
            [5, "SOLD", 0, 12.50, 1, 12.50, 12.50])

    def testUnsoldSuccess(self):
        self.auction_house.add_item([15, 8, "SELL", "tv_1", 250.00, 20])
        self.auction_house.bid_item([18, 1, "BID", "tv_1", 150.00])
        self.auction_house.bid_item([19, 3, "BID", "tv_1", 200.00])
        self.auction_house.heartbeat_check([20])
        self.auction_house.bid_item([21, 3, "BID", "tv_1", 300.00])
        item = self.auction_house.auction_list["tv_1"]
        self.assertListEqual(
            [item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
             item.highest_bid, item.lowest_bid],
            [8, "UNSOLD", 0, 0, 2, 200.00, 150.00])

    def testUnsoldFailure(self):
        self.auction_house.add_item([15, 8, "SELL", "tv_1", 250.00, 20])
        self.auction_house.bid_item([18, 1, "BID", "tv_1", 150.00])
        self.auction_house.bid_item([19, 3, "BID", "tv_1", 200.00])
        self.auction_house.heartbeat_check([20])
        self.auction_house.bid_item([21, 3, "BID", "tv_1", 300.00])
        item = self.auction_house.auction_list["tv_1"]
        self.assertListEqual(
            [item.current_owner, item.status, item.last_bid, item.current_bid, item.total_valid_bid,
             item.highest_bid, item.lowest_bid],
            [8, "UNSOLD", 0, 0, 3, 300.00, 150.00])
