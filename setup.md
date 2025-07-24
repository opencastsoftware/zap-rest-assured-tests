## API ZAP Setup

1. **Download ZAP**  
   Get the installer from [OWASP ZAP Download](https://www.zaproxy.org/download/).


2. **Request Admin Rights**  
   If you need admin privileges, follow the instructions. Please enter Opencast email id when prompted:  
   [Requesting Admin rights](https://opencastsoftware.atlassian.net/wiki/spaces/IKB/pages/4285857794/Guide+-+Requesting+Admin+rights)


3. **Install ZAP**  
   Move the downloaded ZAP file into your `/Applications` folder.


4. **Open ZAP GUI**  
   On first launch, you may see a warning:  
   `"ZAP.app" cannot be opened because the developer cannot be verified.`  
   To resolve this, close the Zap cannot be opened prompt by clicking “Done”. Then go to **System Preferences > Security & Privacy** and click **Open Anyway** to proceed.
   
   After ZAP opens, you will see a prompt asking whether you want to persist the session. Choose to persist or not based on your needs.
   For more details, refer to the ZAP session persistence documentation - https://www.zaproxy.org/docs/desktop/ui/dialogs/persistsession/

   Update All addons when prompted to ensure you have the latest security features and fixes before running tests


5. **How to start ZAP in Daemon Mode manually**  
   Only one instance of ZAP can run at a time. If you want to run ZAP in daemon mode manually, close the ZAP GUI first. Then, you can start ZAP in daemon mode using the command line.
   
   Open Terminal and run:
   ```bash
   /Applications/Zap.app/Contents/MacOS/ZAP.sh -daemon -port 8080 -host 127.0.0.1 -config api.disablekey=true
   ```
   ZAP will listen on `127.0.0.1:8080`.

**Note**:
1. ZAP is started automatically by the shell script during test execution. You do not need to run above command manually or launch ZAP GUI when running tests.
2. ZAP (in either GUI or Daemon mode) should not already be running when you execute the [start-zap-and-run.sh](start-zap-and-run.sh) script
