package MainBranch.Database;

import java.io.*;
import java.net.*;
import java.sql.ResultSet;

public class ViewDatabaseClient
{
    public static ResultSet MainDatabase() throws Exception
    {
        ResultSet rs = null;

        InputStream in = null;
        OutputStream out = null;

        try{
            Socket socket = new Socket("127.0.0.1", 1997);
            in = socket.getInputStream();
            //ResultSet rs1
            int i = in.read();
        }
        catch (IOException el)
        {
            el.printStackTrace();
        }
        return rs;
    }
}
