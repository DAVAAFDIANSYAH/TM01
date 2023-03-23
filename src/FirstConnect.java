import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {

        //reques
        connectURI koneksisaya = new connectURI();
        URL myAddress = koneksisaya.buildURl
                ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        //response
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
//        System.out.println(response);

        assert response !=null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList <RespondModel> RespondModel = new ArrayList<>();

        for (int i =0; i <responseJSON.length(); i++) {

            RespondModel resmodel = new RespondModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resmodel.setI_name(myJSONObject.getString("i_name"));
            resmodel.setI_sell(myJSONObject.getString("i_sell"));

            RespondModel.add(resmodel);
        }
        System.out.println();
        for (int index=0; index<RespondModel.size();index++){
            System.out.println("nama : "+
                  RespondModel.get(index).getI_name());
            System.out.println("qty : "+ RespondModel.get(index));
            System.out.println("harga : " +
            RespondModel.get(index).getI_sell());
        }
    }
}
