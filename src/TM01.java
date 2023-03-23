import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TM01 extends JFrame{
    private JPanel theFrame;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextArea textArea1;


    public TM01(){
        setContentPane(theFrame);
        setTitle("barang");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {

        TM01 content = new TM01();

        connectURI koneksisaya = new connectURI();
        URL myAddress = koneksisaya.buildURl
                ("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        //response
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<RespondModel> list = new ArrayList<>();

        for (int i = 0; i < responseJSON.length(); i++) {
            RespondModel myData = new RespondModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            myData.setI_name(myJSONObject.getString("i_name"));
            myData.setI_sell(myJSONObject.getString("i_sell"));
            myData.setI_name(myJSONObject.getString("i_qty"));
            list.add(myData);
        }
        content.button1.addActionListener(e -> {
                for (int index = 0; index < list.size(); index++) {
                    String namaBarang = String.valueOf(list.get(index).getI_name().charAt(0));
                    String stok = list.get(index).getI_qty();
                    //mengkonversikan menjadi int
                    int harga = Integer.parseInt(list.get(index).getI_sell());
                    if (namaBarang.contains("S") && harga < 7000 && stok != null) {
                        content.textArea1.append("nama barang : " + namaBarang +
                                "\nharga : " + harga +
                                "\nstok : " + stok + "\n");
                }
            }
        });
    }
}


