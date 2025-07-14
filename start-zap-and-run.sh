#!/bin/bash

# Path to your ZAP executable - adjust if needed
ZAP_PATH="/Applications/Zap.app/Contents/MacOS/zap.sh"
export PATH="/opt/homebrew/bin:$PATH"

# Port ZAP will listen on
ZAP_PORT=8080

# Start ZAP in daemon mode, redirect output to zap.log
echo "Starting ZAP..."
$ZAP_PATH -daemon -port $ZAP_PORT > zap.log 2>&1 &

# Capture ZAP PID so we can manage it later if needed
ZAP_PID=$!
echo "ZAP started with PID $ZAP_PID"

# Wait for ZAP to be ready (adjust timeout as needed)
echo "Waiting for ZAP to initialize..."
sleep 15

echo "Running tests with Maven..."
mvn test

# After tests are done, stop ZAP gracefully
echo "Stopping ZAP..."
kill $ZAP_PID
echo "ZAP stopped."
