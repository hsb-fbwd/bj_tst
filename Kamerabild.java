
//import java.awt.Canvas;
//import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;

//import javax.imageio.ImageIO;
//import javax.swing.JFrame;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class Kamerabild {
    static BufferedImage i;
    Properties prop=new Properties();
    String camURL;
    String camPath;
    String camUser;
    String camPw;
    String reqString;
    File pictureFile;

    public Kamerabild () throws IOException {

    }

    public void getContent() throws ClientProtocolException, IOException{
        try
        {
            URL url = new URL( "https://www.github.com/hsb-fbwd/fh38" );
            InputStreamReader is = new InputStreamReader( url.openStream() );
            BufferedReader in = new BufferedReader( is );
            for ( String s; ( s = in.readLine() ) != null; )
                System.out.println( s );

            in.close();
        }
        catch ( Exception e ) {
            System.out.println( "MalformedURLException: " + e );
        }
    }

    public void getContentori() throws ClientProtocolException, IOException{
        DefaultHttpClient client = new DefaultHttpClient();
        reqString = "https://github.com/hsb-fbwd/fh38";
        reqString = "https://www.dwd.de";

        // pass our credentials to HttpClient, they will only be used for
        // authenticating to servers with realm "realm" on the host
        // "www.verisign.com", to authenticate against
        // an arbitrary realm or host change the appropriate argument to null.
        client.getCredentialsProvider().setCredentials(
            new AuthScope(camURL, 80),
            new UsernamePasswordCredentials("hsb-fbwd", "v4vmwSSnk1"));
        HttpGet get = new HttpGet(reqString);
        // execute the GET
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        outputKonsole("Entity got");

        InputStream in = entity.getContent();
        char readChar = (char)in.read();
        StringBuffer rdBuf=new StringBuffer();
        rdBuf.append(readChar);
        while( readChar != -1 ){
            readChar = (char)in.read();
            rdBuf.append(readChar);
        }
        in.close();
        outputKonsole(rdBuf.toString());
        // release any connection resources used by the method
        client.getConnectionManager().shutdown();
        outputKonsole("All closed");
        // Only for Debugging - Achtung: Applikation endet nicht nach dem Aufruf der Methode!!
        //  showInFrame(outputFile);
    }

    public File getPictName(){
        return pictureFile;
    }

    //	    public void showInFrame(File cameraPict){
    //	        JFrame f = new JFrame();
    //            try {
    //				i = ImageIO.read(cameraPict);
    //			} catch (IOException e) {
    //				// TODO Auto-generated catch block
    //				e.printStackTrace();
    //			}
    //	        f.add(new Canvas() {
    //	        	 
    //	            @Override
    //	            public void paint(Graphics g) {
    //	                g.drawImage(i, 0, 0, this);
    //	            }
    //	        });
    //	        f.setSize(100, 100);
    //	        f.setVisible(true);
    //	    }

    private void outputKonsole(String out){
        if (prop.getProperty("Konsole").equals("ON")){
            System.out.println(out);
        }
    }

    private String getFileTime(){
        // Create a date-format
        DateFormat fileNameTimeFormat= new SimpleDateFormat("yyyyMMddHHmm"); 
        // return the actual time, formatted with TimeFormat
        return fileNameTimeFormat.format(new Date());
    }

}
