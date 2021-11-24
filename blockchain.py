 #Tutorial to explain how a blockchain works

import hashlib
import json
from time import time

class Blockchain(object):
    def __init__(self):
        self.chain = []
        self.pending_transactions = []
        self.new_block(previous_hash="The rise of the digital world is upon us.", proof=100)

    def new_block(self, proof, previous_hash=None):
        block = {
            'index': len(self.chain) + 1,
            'timestamp': time(),
            'transactions': self.pending_transactions,
            'proof': proof,
            'previous_hash': previous_hash or self.hash(self.chain[-1]), 
        }
        self.pending_transactions = []
        self.chain.append(block)

        return block

    @property
    def last_block(self):
        return self.chain[-1]

    def new_transaction(self, sender, recipient, amount):
        transaction = {
            'sender': sender,
            'recipient': recipient,
            'amount': amount

        }

        self.pending_transactions.append(transaction)
        return self.last_block['index'] + 1

    def hash(self, block):
        string_object = json.dumps(block, sort_keys=True)
        block_string = string_object.encode()

        raw_hash = hashlib.sha256(block_string)
        hex_hash = raw_hash.hexdigest()

        return hex_hash

if __name__ == '__main__':
    blockchain = Blockchain()
    print()
    t1 = blockchain.new_transaction("Satoshi", "Halfin", '1000 BTC')
    t2 = blockchain.new_transaction("Satoshi", "Halfin", '500 BTC')
    t3 = blockchain.new_transaction("Satoshi", "Halfin", '100 BTC')
    blockchain.new_block(12345)
    print()
    t4 = blockchain.new_transaction("Satoshi", "Halfin", '50 BTC')
    t5 = blockchain.new_transaction("Satoshi", "Halfin", '25 BTC')
    t6 = blockchain.new_transaction("Satoshi", "Halfin", '12.5 BTC')
    blockchain.new_block(6789)
    print()
    t7 = blockchain.new_transaction("Satoshi", "Halfin", '6.25 BTC')

    print("Blockchain: ", blockchain.chain)
