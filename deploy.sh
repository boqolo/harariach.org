#!/bin/bash

echo "Copying files over to the worm..."
scp -r public/* ray@192.46.222.238:~/www/harariach
echo "Done!"
