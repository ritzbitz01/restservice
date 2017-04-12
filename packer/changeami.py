import json
import os

filename = 'example.json'
with open(filename, 'r') as f:
    data = json.load(f)
    data['builders'][0]['ami_name'] = 'updated_name'

os.remove(filename)
with open(filename, 'w') as f:
    json.dump(data, f, indent=4)
