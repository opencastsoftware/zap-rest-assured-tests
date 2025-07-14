## API ZAP Setup

1. **Download ZAP**  
   Get the installer from [OWASP ZAP Download](https://www.zaproxy.org/download/).


2. **Request Admin Rights**  
   If you need admin privileges, follow the instructions here:  
   [Requesting Admin rights](https://opencastsoftware.atlassian.net/wiki/spaces/IKB/pages/4285857794/Guide+-+Requesting+Admin+rights)


3. **Install ZAP**  
   Move the downloaded ZAP file into your `/Applications` folder.


4. **Open ZAP GUI**  
   On first launch, you may see a warning:  
   `"ZAP.app" cannot be opened because the developer cannot be verified.`  
   To resolve this, go to **System Preferences > Security & Privacy** and click **Open Anyway** to proceed.


5. **How to start ZAP in Daemon Mode manually**  
   Open Terminal and run:
   ```bash
   /Applications/Zap.app/Contents/MacOS/ZAP.sh -daemon -port 8080 -host 127.0.0.1 -config api.disablekey=true
   ```
   ZAP will listen on `127.0.0.1:8080`.

**Note**:
1. ZAP is started automatically by the shell script during test execution. You do not need to run above command manually when running tests.
2. ZAP (in either GUI or Daemon mode) should not already be running when you execute the [start-zap-and-run.sh](start-zap-and-run.sh) script

Add this section to your `README.md` for clear ZAP setup instructions.