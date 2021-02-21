package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InfrastructureDepartment {

    public final static String BILLBOARD_FILE_NAME = "data/billboard.bbd";

    private List<Billboard> billboards;

    public InfrastructureDepartment() {
        billboards = new ArrayList<>();
    }

    public void addBillboard(double w, double h, boolean iu, String b) throws IOException {
        billboards.add(new Billboard(w,h,iu,b));
        saveBillboards();
    }

    private void saveBillboards() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BILLBOARD_FILE_NAME));
        oos.writeObject(billboards);
        oos.close();
    }

    public void loadBillboards() throws IOException, ClassNotFoundException{
        File f = new File(BILLBOARD_FILE_NAME);
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            billboards = (List<Billboard>)ois.readObject();
            ois.close();
        }
    }

    public void exportDangerousBillboardReport(String fn) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fn,true));
        for (Billboard b : billboards) {
            pw.println(b.getWidth() + "|" + b.getHeight() + "|" + b.isInUse() + "|" + b.getBrand());
        }
        pw.close();
    }

    public void importData(String fn) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fn));
        String line = br.readLine();
        while (line != null){
            try {
                String[] parts = line.split("\\|");  // the regex could be a constant = FILESEPARATOR = "|"
                addBillboard(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), Boolean.parseBoolean(parts[2]), parts[3]);
                line = br.readLine();
            } catch (NumberFormatException nf){
                line = br.readLine();
            }
        }
        br.close();
        saveBillboards();
    }

    public List<Billboard> getBillboards() {
        return billboards;
    }

}
