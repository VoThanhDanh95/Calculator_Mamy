package tut1.calculator1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {


    EditText edt1,edt2;
    Button btnNam,btnHn,btndel;
    String str1="";
    String str3="";
    String str4="";
    String dai="";
    String daitinhtien="";
    String chuanhoachuoi="";
    long kq3c=0;
    long kq2c=0;
    int sohoanvi=0;
    int socap=0;
    String[] str2;
    String[] chuanhoasoluongso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText)findViewById(R.id.edtso1);
        edt2=(EditText)findViewById(R.id.edtso2);

        btnNam=(Button)findViewById(R.id.btnNam);
        btnNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (!chuanhoachuoi.matches("((1f|2f) (\\d)+(\\.(\\d)+)* ((b|f|kk|mm|fc|ft|kc|ff) (\\d)+ )+,)+"))
                str1 = edt1.getText().toString();

                str1 = str1.replaceAll(" ", "");
                //str1=str1.replaceAll("n", "");
                str1 = str1.replaceAll("\n", ",");
                str1 = str1.replaceAll("(\\.)+", "\\.");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?(\\d)+(\\.(\\d)+)*((b|xcd|bd|dc|ch|dx|dt|da|xc|dd|x|dau|duoi|cheo|đ)(\\d)+)+)\\.","$1,");
                str1 = str1.replaceAll(",+", ",");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?(\\d)+(\\.(\\d)+)*((d)(\\d)+)+)\\.","$1,");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?(\\d)+(\\.(\\d)+)*((b|d|xcd|bd|xc|dd|x|dau|duoi)+(\\d)+)+)\\.","$1,");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?((\\d)+\\.(\\d)+)+(\\.(\\d)+)*((dc|ch|dx|dt|da|cheo)(\\d)+)+)\\.","$1,");
                //str1=str1.replaceAll("((1d|2d)?(\\d)+\\.(\\d)+)+\\.","$1,");
                //edt2.setText(str1);

                if (str1.length() == 0) {
                    edt1.setError("Nhập dữ liệu vào");
                } else {

                    str2 = str1.split(",");
                    for (String test : str2) {
                        //edt2.setText(test);
                        //xoa chu n
                        if (test.startsWith("."))
                            test = test.substring(1);
                        if (test.endsWith(".")) {
                            test = test.substring(0, test.length() - 1);
                            //edt2.setText(test);
                        }

                        test = test.replaceAll("\\.(c|C)heo", " fc ");
                        test = test.replaceAll("(c|C)heo\\.", " fc ");
                        test = test.replaceAll("(c|C)heo", " fc ");


                        test = test.replaceAll("\\.(d|đ|D|Đ)uoi", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)uoi\\.", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)uoi", " f ");


                        test = test.replaceAll("\\.(x|X)cd", " kk "); // kk la xcd
                        test = test.replaceAll("(x|X)cd\\.", " kk "); // kk la xcd
                        test = test.replaceAll("(x|X)cd", " kk "); // kk la xcd

                        test = test.replaceAll("\\.(b|B)ld", " mm "); // kk la xcd
                        test = test.replaceAll("(b|B)ld\\.", " mm "); // kk la xcd
                        test = test.replaceAll("(b|B)ld", " mm "); // kk la xcd

                        test = test.replaceAll("\\.(d|đ|D|Đ)au", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)au\\.", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)au", " f ");

                        test = test.replaceAll("\\.(d|đ|D|Đ)ui", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)ui\\.", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)ui", " f ");

                        if (test.startsWith("1d")) {
                            test = test.substring(2);
                            test = "1f " + test;
                        } else if (test.startsWith("2d")) {
                            test = test.substring(2);
                            test = "2f " + test;
                        } else if (test.startsWith("2d.")) {
                            test = test.substring(3);
                            test = "2f " + test;
                        } else if (test.startsWith("1d.")) {
                            test = test.substring(3);
                            test = "1f " + test;
                        }

                        //test=test.replaceFirst("1d\\.", "1f "); // d anh xa thanh f
                        //test=test.replaceFirst("1d", "1f "); // d anh xa thanh f
                        //test=test.replaceFirst("2d\\.", "2f ");
                        //test=test.replaceFirst("2d", "2f ");
                        test = test.replaceFirst("(T|t)(P|p)", "1f ");

                        test = test.replaceFirst("(d|đ|D|Đ)(t|T|n|N)", "1f ");

                        test = test.replaceFirst("(b|B)(t|T)", "1f ");

                        test = test.replaceFirst("(v|V)(t|T)", "1f ");
                        test = test.replaceFirst("(c|C)(t|T)", "1f ");
                        test = test.replaceFirst("(t|T)(n|N)", "1f ");

                        test = test.replaceFirst("(a|A)(g|G)", "1f ");
                        test = test.replaceFirst("(s|S)(b|B)", "1f ");
                        test = test.replaceFirst("(v|V)(l|L)", "1f ");
                        test = test.replaceFirst("(t|T|k|K)(g|G)", "1f ");
                        //test=test.replaceFirst("(k|K)(g|G)","1f ");
                        test = test.replaceFirst("(l|L)(a|A)", "1f ");


                        //bao
                        test = test.replaceAll("\\.(b|B)(d|đ|D|Đ)", " mm "); // mm la bao dao
                        test = test.replaceAll("(b|B)(d|đ|D|Đ)\\.", " mm "); // mm la bao dao
                        test = test.replaceAll("(b|B)(d|đ|D|Đ)", " mm "); // mm la bao dao

                        test = test.replaceAll("\\.(b|B)l", " b ");
                        test = test.replaceAll("(b|B)l\\.", " b ");
                        test = test.replaceAll("(b|B)l", " b ");

                        //da
                        test = test.replaceAll("(d|đ|D|Đ)x\\.", " fc ");
                        test = test.replaceAll("\\.(d|đ|D|Đ)x", " fc ");
                        test = test.replaceAll("(d|đ|D|Đ)x", " fc ");


                        test = test.replaceAll("(d|đ|D|Đ)c\\.", " fc ");
                        test = test.replaceAll("\\.(d|đ|D|Đ)c", " fc ");
                        test = test.replaceAll("(d|đ|D|Đ)c", " fc ");

                        test = test.replaceAll("(c|C)h\\.", " fc ");
                        test = test.replaceAll("\\.(c|C)h", " fc ");
                        test = test.replaceAll("(c|C)h", " fc ");

                        test = test.replaceAll("\\.dt", " ft ");
                        test = test.replaceAll("dt\\.", " ft ");
                        test = test.replaceAll("dt", " ft ");

                        test = test.replaceAll("\\.(d|đ|D|Đ)a", " ft ");
                        test = test.replaceAll("(d|đ|D|Đ)a\\.", " ft ");
                        test = test.replaceAll("(d|đ|Đ|D)a", " ft ");

                        //xieu chu

                        test = test.replaceAll("(x|X)c\\.", " kc "); // kc la xc
                        test = test.replaceAll("\\.(x|X)c", " kc "); // kc la xc
                        test = test.replaceAll("(x|X)c", " kc "); // kc la xc

                        test = test.replaceAll("(x|X)(d|đ|D|Đ)\\.", " kk "); // kk la xcd
                        test = test.replaceAll("\\.(x|X)(d|đ|D|Đ)", " kk "); // kk la xcd
                        test = test.replaceAll("(x|X)(d|đ|D|Đ)", " kk "); // kk la xcd


                        //dau duoi

                        test = test.replaceAll("(d|đ|Đ|D)(d|đ|Đ|D)\\.", " ff ");
                        test = test.replaceAll("\\.(d|đ|Đ|D)(d|đ|Đ|D)", " ff ");
                        test = test.replaceAll("(d|đ|Đ|D)(d|đ|Đ|D)", " ff ");

                        test = test.replaceAll("\\.(d|đ|D|Đ)", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)\\.", " f ");
                        test = test.replaceAll("(d|đ|D|Đ)", " f ");
                        //test=  test.replaceAll("\\.đ"," f ");
                        //test=  test.replaceAll("đ\\."," f ");
                        //test=  test.replaceAll("đ"," f ");
                        test = test.replaceAll("\\.(b|B)", " b ");
                        test = test.replaceAll("(b|B)\\.", " b ");
                        test = test.replaceAll("(b|B)", " b ");

                        test = test.replaceAll("\\.(x|X)", " kc ");
                        test = test.replaceAll("(x|X)\\.", " kc ");
                        test = test.replaceAll("(x|X)", " kc ");
                        test = test.replaceAll("n", "");

                        //XOA KHOANG TRANG
                        test = test.trim();
                        test = test.replaceAll("\\s+", " ");
                        if (test.startsWith("2f")) {
                            //test="2d"+test;
                            dai = "2f ";
                        } else if (test.startsWith("1f")) {
                            dai = "1f ";
                        } else {
                            test = dai + test;
                        }
                        chuanhoachuoi += test + ",";
                    }


                    // chuan hoa lai so luong so trong tung phan tu
                    chuanhoasoluongso = chuanhoachuoi.split(",");
                    chuanhoachuoi = "";
                    for (String str : chuanhoasoluongso) {
                        String[] tungphantu = str.split(" ");
                        // thay dau . thanh " "
                        tungphantu[1] = tungphantu[1].replaceAll("\\.", " ");
                        tungphantu[1] = tungphantu[1].trim();
                        tungphantu[1] = tungphantu[1].replaceAll("\\s+", " ");

                        // thay nguoc lai
                        tungphantu[1] = tungphantu[1].replaceAll(" ", ".");
                        for (String test : tungphantu) {
                            chuanhoachuoi += test + " ";
                        }
                        chuanhoachuoi += ",";
                    }


                    //kiem tra chuoi lan cuoi sau khi chuan hoa

                    if (!chuanhoachuoi.matches("((1f|2f) (\\d)+(\\.(\\d)+)* ((b|f|kk|mm|fc|ft|kc|ff) (\\d)+(\\.\\d)? )+,)+")) {
                        edt1.setError("");
                        str2 = chuanhoachuoi.split(",");
                        chuanhoachuoi = "";
                        for (String test : str2) {
                            //xoa chu n

                            test = test.replaceFirst("1f", "1d");
                            test = test.replaceFirst("2f", "2d");

                            test = test.replaceAll("ff", "dd");
                            test = test.replaceAll("kk", "xcd");

                            test = test.replaceAll("mm", "bd");
                            test = test.replaceAll("fc", "dc");

                            test = test.replaceAll("ft", "dt");
                            test = test.replaceAll("kc", "x");

                            test = test.replaceAll("f", "d");

                            chuanhoachuoi += test + ",";
                        }

                        edt2.setText(chuanhoachuoi + "\n" + "Namnhapsai");
                        chuanhoachuoi = "";
                    } else

                    {
                        //try {
                        str2 = chuanhoachuoi.split(",");
                        List<String> stringList = new ArrayList<String>(Arrays.asList(str2));
                        for (String str : stringList) {
                            String[] tungphantu = str.split(" ");

                            String[] soluongso = tungphantu[1].split("\\.");
                            daitinhtien = tungphantu[0];
                            if (daitinhtien.equals("2f")) {
                                for (int i = 2; i < tungphantu.length - 1; i = i + 2) {
                                    if (tungphantu[i].equals("ff")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 4;
                                        str4 = str4 + soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 4 + "\n";
                                    } else if (tungphantu[i].equals("b")) {
                                        for (String c : soluongso) {
                                            if (c.length() == 2) {
                                                kq2c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 36;
                                                str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 36 + "\n";
                                            } else if (c.length() == 3) {
                                                kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 34;
                                                str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 34 + "\n";
                                            } else if (c.length() == 4) {
                                                kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 32;
                                                str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 32 + "\n";
                                            }
                                        }
                                    } else if (tungphantu[i].equals("mm")) {
                                        for (String c : soluongso) {
                                            if (c.length() == 3) {
                                                if (c.substring(0, 1).equals(c.substring(1, 2)) || c.substring(0, 1).equals(c.substring(2, 3))
                                                        || c.substring(1, 2).equals(c.substring(2, 3))) {
                                                    sohoanvi = 3;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 34;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 34 + "\n";

                                                } else {
                                                    sohoanvi = 6;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 34;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 34 + "\n";
                                                }
                                            } else if (c.length() == 4) {
                                                int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
                                                a1 = Integer.parseInt(c.substring(0, 1));
                                                a2 = Integer.parseInt(c.substring(1, 2));
                                                a3 = Integer.parseInt(c.substring(2, 3));
                                                a4 = Integer.parseInt(c.substring(3, 4));
                                                if (((a1 == a2) && (a1 == a3) && (a1 != a4)) || ((a1 == a2) && (a1 == a4) && (a1 != a3)) || ((a2 == a3) && (a2 == a4) && (a2 != a1))
                                                        || ((a1 == a3) && (a1 == a4) && (a1 != a2))) {
                                                    sohoanvi = 4;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32 + "\n";
                                                } else if ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) //4con#
                                                {
                                                    sohoanvi = 24;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32 + "\n";
                                                } else if ((a1 == a2) && (a1 == a3) && (a1 == a4)) {
                                                    sohoanvi = 1;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32 + "\n";

                                                } else if (((a1 == a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) || ((a1 != a2) && (a1 == a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4))
                                                        || ((a1 != a2) && (a1 != a3) && (a1 == a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) || ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 == a3) && (a2 != a4) && (a3 != a4))
                                                        || ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 == a4) && (a3 != a4)) || ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 == a4))) {
                                                    sohoanvi = 12;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32 + "\n";
                                                } else {
                                                    sohoanvi = 6;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 32 + "\n";
                                                }
                                            }
                                            sohoanvi = 0;
                                        }
                                    } else if (tungphantu[i].equals("kc")) {
                                        for (String c : soluongso) {
                                            kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 4;
                                            str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 4 + "\n";
                                        }
                                    } else if (tungphantu[i].equals("kk")) {

                                        for (String c : soluongso) {
                                            if (c.substring(0, 1).equals(c.substring(1, 2)) || c.substring(0, 1).equals(c.substring(2, 3))
                                                    || c.substring(1, 2).equals(c.substring(2, 3)))
                                                sohoanvi = 3;
                                            else sohoanvi = 6;

                                            kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 4;
                                            str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 4 + "\n";
                                            sohoanvi = 0;
                                        }
                                        //kq+=soluongso.length * Float.parseFloat(tungphantu[i+1].substring(0,tungphantu[i+1].length()-1));

                                    } else if (tungphantu[i].equals("fc") || tungphantu[i].equals("ft")) {

                                        for (int d = 0; d < soluongso.length; d++)
                                            socap += d;
                                        kq2c += socap * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 * 36;
                                        str4 = str4 + socap * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 * 36 + "\n";
                                        socap = 0;
                                    } else if (tungphantu[i].equals("f")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2;
                                        str4 = str4 + soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 + "\n";
                                    }
                                }
                            } else if (daitinhtien.equals("1f")) {
                                for (int i = 2; i < tungphantu.length - 1; i = i + 2) {
                                    if (tungphantu[i].equals("ff")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2;
                                        str4 = str4 + soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 + "\n";
                                    } else if (tungphantu[i].equals("b")) {
                                        for (String c : soluongso) {
                                            if (c.length() == 2) {
                                                kq2c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 18;
                                                str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 18 + "\n";
                                            } else if (c.length() == 3) {
                                                kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 17;
                                                str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 17 + "\n";
                                            } else if (c.length() == 4) {
                                                kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 16;
                                                str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 16 + "\n";
                                            }
                                        }
                                    } else if (tungphantu[i].equals("mm")) {
                                        for (String c : soluongso) {
                                            if (c.length() == 3) {
                                                if (c.substring(0, 1).equals(c.substring(1, 2)) || c.substring(0, 1).equals(c.substring(2, 3))
                                                        || c.substring(1, 2).equals(c.substring(2, 3))) {
                                                    sohoanvi = 3;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 17;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 17 + "\n";
                                                } else {
                                                    sohoanvi = 6;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 17;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 17 + "\n";
                                                }
                                            } else if (c.length() == 4) {
                                                int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
                                                a1 = Integer.parseInt(c.substring(0, 1));
                                                a2 = Integer.parseInt(c.substring(1, 2));
                                                a3 = Integer.parseInt(c.substring(2, 3));
                                                a4 = Integer.parseInt(c.substring(3, 4));
                                                if (((a1 == a2) && (a1 == a3)) || ((a1 == a2) && (a1 == a4)) || ((a2 == a3) && (a2 == a4)) || ((a1 == a3) && (a1 == a4))) {
                                                    sohoanvi = 4;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16 + "\n";
                                                } else if ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) //4con#
                                                {
                                                    sohoanvi = 24;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16 + "\n";
                                                } else if ((a1 == a2) && (a1 == a3) && (a1 == a4)) {
                                                    sohoanvi = 1;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16 + "\n";

                                                } else if (((a1 == a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) || ((a1 != a2) && (a1 == a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4))
                                                        || ((a1 != a2) && (a1 != a3) && (a1 == a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) || ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 == a3) && (a2 != a4) && (a3 != a4))
                                                        || ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 == a4) && (a3 != a4)) || ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 == a4))) {
                                                    sohoanvi = 12;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16 + "\n";
                                                } else {
                                                    sohoanvi = 6;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16;
                                                    str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 16 + "\n";
                                                }
                                            }

                                            sohoanvi = 0;
                                        }
                                    } else if (tungphantu[i].equals("kc")) {
                                        kq3c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2;
                                        str4 = str4 + soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 + "\n";
                                    } else if (tungphantu[i].equals("kk")) {

                                        for (String c : soluongso) {
                                            if (c.substring(0, 1).equals(c.substring(1, 2)) || c.substring(0, 1).equals(c.substring(2, 3))
                                                    || c.substring(1, 2).equals(c.substring(2, 3)))
                                                sohoanvi = 3;
                                            else sohoanvi = 6;

                                            kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 2;
                                            str4 = str4 + Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 2 + "\n";
                                            sohoanvi = 0;
                                        }
                                        //kq+=soluongso.length * Float.parseFloat(tungphantu[i+1].substring(0,tungphantu[i+1].length()-1));

                                    } else if (tungphantu[i].equals("ft") || tungphantu[i].equals("fc")) {

                                        for (int d = 0; d < soluongso.length; d++)
                                            socap += d;
                                        kq2c += socap * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 * 18;
                                        str4 = str4 + socap * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 * 18 + "\n";
                                        socap = 0;
                                    } else if (tungphantu[i].equals("f")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length()));
                                        str4 = str4 + soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) + "\n";
                                    }

                                }
                            }
                        }


                        //}
                        //catch   (Exception e1)
                        //    {
                        //        edt1.setError("Nhập sai");
                        //   }

                        //chuan hoa chuoi lai dung dinh dang ban dau
                        str2 = chuanhoachuoi.split(",");
                        chuanhoachuoi = "";
                        for (String test : str2) {
                            //xoa chu n

                            test = test.replaceFirst("1f", "1d");
                            test = test.replaceFirst("2f", "2d");

                            test = test.replaceAll("ff", "dd");
                            test = test.replaceAll("kk", "xcd");

                            test = test.replaceAll("mm", "bd");
                            test = test.replaceAll("fc", "dc");

                            test = test.replaceAll("ft", "dt");
                            test = test.replaceAll("kc", "x");

                            test = test.replaceAll("f", "d");

                            chuanhoachuoi += test + ",";
                        }
                        //edt2.setText(chuanhoachuoi+"\n"+"nhapsai");
                        str3 = " NAM 2c: " + Long.toString(kq2c) + "--NAM 3c: " + Long.toString(kq3c);//+" "+chuanhoachuoi;
                        //str3= " 2c: "+Long.toString(kq2c)+"--3c: "+Long.toString(kq3c);
                        kq2c = 0;
                        kq3c = 0;
                        edt2.setText(str4 + chuanhoachuoi + "\n" + str3);
                        str3 = "";
                        str4 = "";
                        chuanhoachuoi = "";

                    }
                }

                //vi tri comment
            }
        });




        //btn HNNNN

        btnHn=(Button)findViewById(R.id.btnHn);
        btnHn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //if (!chuanhoachuoi.matches("((1f|2f) (\\d)+(\\.(\\d)+)* ((b|f|kk|mm|fc|ft|kc|ff) (\\d)+ )+,)+"))
                str1=edt1.getText().toString();

                str1=str1.replaceAll(" ", "");
                //str1=str1.replaceAll("n", "");
                str1=str1.replaceAll("\n",",");
                str1=str1.replaceAll("(\\.)+","\\.");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?(\\d)+(\\.(\\d)+)*((b|xcd|bd|dc|ch|dx|dt|da|xc|dd|x|dau|duoi|cheo|đ)(\\d)+)+)\\.","$1,");
                str1=str1.replaceAll(",+",",");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?(\\d)+(\\.(\\d)+)*((d)(\\d)+)+)\\.","$1,");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?(\\d)+(\\.(\\d)+)*((b|d|xcd|bd|xc|dd|x|dau|duoi)+(\\d)+)+)\\.","$1,");
                //str1=str1.replaceAll("((1d|2d)?(\\.)?((\\d)+\\.(\\d)+)+(\\.(\\d)+)*((dc|ch|dx|dt|da|cheo)(\\d)+)+)\\.","$1,");
                //str1=str1.replaceAll("((1d|2d)?(\\d)+\\.(\\d)+)+\\.","$1,");
                //edt2.setText(str1);

                if (str1.length()==0)
                {
                    edt1.setError("Nhập dữ liệu vào");
                }
                else
                {

                    str2=str1.split(",");
                    for (String test:str2)
                    {
                        //edt2.setText(test);
                        //xoa chu n
                        if (test.startsWith("."))
                            test=test.substring(1);
                        if (test.endsWith(".")) {
                            test = test.substring(0, test.length() - 1);
                            //edt2.setText(test);
                        }

                        test=test.replaceAll("\\.(c|C)heo"," fc ");
                        test=test.replaceAll("(c|C)heo\\."," fc ");
                        test=test.replaceAll("(c|C)heo"," fc ");


                        test=test.replaceAll("\\.(d|đ|D|Đ)uoi"," fz ");
                        test=test.replaceAll("(d|đ|D|Đ)uoi\\."," fz ");
                        test=test.replaceAll("(d|đ|D|Đ)uoi"," fz ");



                        test=test.replaceAll("\\.(x|X)cd"," kk "); // kk la xcd
                        test=test.replaceAll("(x|X)cd\\."," kk "); // kk la xcd
                        test=test.replaceAll("(x|X)cd"," kk "); // kk la xcd

                        test=test.replaceAll("\\.(b|B)ld"," mm "); // kk la xcd
                        test=test.replaceAll("(b|B)ld\\."," mm "); // kk la xcd
                        test=test.replaceAll("(b|B)ld"," mm "); // kk la xcd

                        test=test.replaceAll("\\.(d|đ|D|Đ)au", " f ");
                        test=test.replaceAll("(d|đ|D|Đ)au\\.", " f ");
                        test=test.replaceAll("(d|đ|D|Đ)au", " f ");

                        test=test.replaceAll("\\.(d|đ|D|Đ)ui", " fz ");
                        test=test.replaceAll("(d|đ|D|Đ)ui\\.", " fz ");
                        test=test.replaceAll("(d|đ|D|Đ)ui", " fz ");

                        if (test.startsWith("1d"))
                        {
                            test=test.substring(2);
                            test="1f "+test;
                        }
                        else if (test.startsWith("2d"))
                        {
                            test=test.substring(2);
                            test="2f "+test;
                        }

                        else if (test.startsWith("2d."))
                        {
                            test=test.substring(3);
                            test="2f "+test;
                        }
                        else if (test.startsWith("1d."))
                        {
                            test=test.substring(3);
                            test="1f "+test;
                        }

                        //test=test.replaceFirst("1d\\.", "1f "); // d anh xa thanh f
                        //test=test.replaceFirst("1d", "1f "); // d anh xa thanh f
                        //test=test.replaceFirst("2d\\.", "2f ");
                        //test=test.replaceFirst("2d", "2f ");
                        test=test.replaceFirst("(T|t)(P|p)","1f ");

                        test=test.replaceFirst("(d|đ|D|Đ)(t|T)","1f ");

                        test=test.replaceFirst("(b|B)(t|T)","1f ");

                        test=test.replaceFirst("(v|V)(t|T)","1f ");
                        test=test.replaceFirst("(c|C)(t|T)", "1f ");
                        test=test.replaceFirst("(t|T|h|H)(n|N)","1f ");

                        test=test.replaceFirst("(a|A)(g|G)","1f ");
                        test=test.replaceFirst("(s|S)(b|B)","1f ");
                        test=test.replaceFirst("(v|V)(l|L)","1f ");
                        test=test.replaceFirst("(t|T|k|K)(g|G)", "1f ");
                        //test=test.replaceFirst("(k|K)(g|G)","1f ");
                        test=test.replaceFirst("(l|L)(a|A)", "1f ");





                        //bao
                        test=test.replaceAll("\\.(b|B)(d|đ|D|Đ)", " mm "); // mm la bao dao
                        test=test.replaceAll("(b|B)(d|đ|D|Đ)\\.", " mm "); // mm la bao dao
                        test=test.replaceAll("(b|B)(d|đ|D|Đ)", " mm "); // mm la bao dao

                        test=test.replaceAll("\\.(b|B)l"," b ");
                        test=test.replaceAll("(b|B)l\\."," b ");
                        test=test.replaceAll("(b|B)l"," b ");

                        //da
                        test=test.replaceAll("(d|đ|D|Đ)x\\."," fc ");
                        test=test.replaceAll("\\.(d|đ|D|Đ)x"," fc ");
                        test=test.replaceAll("(d|đ|D|Đ)x"," fc ");


                        test=test.replaceAll("(d|đ|D|Đ)c\\."," fc ");
                        test=test.replaceAll("\\.(d|đ|D|Đ)c"," fc ");
                        test=test.replaceAll("(d|đ|D|Đ)c"," fc ");

                        test=test.replaceAll("(c|C)h\\."," fc ");
                        test=test.replaceAll("\\.(c|C)h"," fc ");
                        test=test.replaceAll("(c|C)h"," fc ");

                        test=test.replaceAll("\\.dt"," ft ");
                        test=test.replaceAll("dt\\."," ft ");
                        test=test.replaceAll("dt"," ft ");

                        test=test.replaceAll("\\.(d|đ|D|Đ)a"," ft ");
                        test=test.replaceAll("(d|đ|D|Đ)a\\."," ft ");
                        test=test.replaceAll("(d|đ|Đ|D)a"," ft ");

                        //xieu chu

                        test= test.replaceAll("(x|X)c\\."," kc "); // kc la xc
                        test= test.replaceAll("\\.(x|X)c"," kc "); // kc la xc
                        test= test.replaceAll("(x|X)c"," kc "); // kc la xc

                        test= test.replaceAll("(x|X)(d|đ|D|Đ)\\."," kk "); // kk la xcd
                        test= test.replaceAll("\\.(x|X)(d|đ|D|Đ)"," kk "); // kk la xcd
                        test= test.replaceAll("(x|X)(d|đ|D|Đ)"," kk "); // kk la xcd


                        //dau duoi

                        test= test.replaceAll("(d|đ|Đ|D)(d|đ|Đ|D)\\."," ff ");
                        test= test.replaceAll("\\.(d|đ|Đ|D)(d|đ|Đ|D)"," ff ");
                        test= test.replaceAll("(d|đ|Đ|D)(d|đ|Đ|D)"," ff ");

                        test=  test.replaceAll("\\.(d|đ|D|Đ)"," f ");
                        test=  test.replaceAll("(d|đ|D|Đ)\\."," f ");
                        test=  test.replaceAll("(d|đ|D|Đ)"," f ");
                        //test=  test.replaceAll("\\.đ"," f ");
                        //test=  test.replaceAll("đ\\."," f ");
                        //test=  test.replaceAll("đ"," f ");
                        test= test.replaceAll("\\.(b|B)"," b ");
                        test= test.replaceAll("(b|B)\\."," b ");
                        test= test.replaceAll("(b|B)"," b ");

                        test= test.replaceAll("\\.(x|X)"," kc ");
                        test= test.replaceAll("(x|X)\\."," kc ");
                        test= test.replaceAll("(x|X)"," kc ");
                        test=test.replaceAll("n","");

                        //XOA KHOANG TRANG
                        test=test.trim();
                        test=test.replaceAll("\\s+"," ");
                        if (test.startsWith("2f"))
                        {
                            //test="2d"+test;
                            dai="2f ";
                        }
                        else if (test.startsWith("1f"))
                        {
                            dai="1f ";
                        }
                        else
                        {
                            test=dai+test;
                        }
                        chuanhoachuoi+=test+",";
                    }





                    // chuan hoa lai so luong so trong tung phan tu
                    chuanhoasoluongso=chuanhoachuoi.split(",");
                    chuanhoachuoi="";
                    for (String str:chuanhoasoluongso)
                    {
                        String[] tungphantu=str.split(" ");
                        // thay dau . thanh " "
                        tungphantu[1]=tungphantu[1].replaceAll("\\."," ");
                        tungphantu[1]=tungphantu[1].trim();
                        tungphantu[1]=tungphantu[1].replaceAll("\\s+"," ");

                        // thay nguoc lai
                        tungphantu[1]=tungphantu[1].replaceAll(" ",".");
                        for (String test:tungphantu)
                        {
                            chuanhoachuoi+=test+" ";
                        }
                        chuanhoachuoi+=",";
                    }


                    //kiem tra chuoi lan cuoi sau khi chuan hoa

                    if (!chuanhoachuoi.matches("((1f|2f) (\\d)+(\\.(\\d)+)* ((b|f|kk|mm|fc|ft|kc|ff|fz) (\\d)+(\\.\\d)? )+,)+"))
                    {
                        edt1.setError("");
                        str2=chuanhoachuoi.split(",");
                        chuanhoachuoi="";
                        for (String test:str2)
                        {
                            //xoa chu n

                            test=test.replaceFirst("1f","1d");
                            test=test.replaceFirst("2f", "2d");

                            test=test.replaceAll("ff", "dd");
                            test=test.replaceAll("fz","dui");
                            test=test.replaceAll("kk","xcd");

                            test=test.replaceAll("mm","bd");
                            test=test.replaceAll("fc","dc");

                            test=test.replaceAll("ft","dt");
                            test=test.replaceAll("kc","x");

                            test=test.replaceAll("f","d");

                            chuanhoachuoi+=test+",";
                        }

                        edt2.setText(chuanhoachuoi+"\n"+"HNnhapsai");
                        chuanhoachuoi="";
                    }
                    else

                    {
                        //try {
                        str2 = chuanhoachuoi.split(",");
                        List<String> stringList = new ArrayList<String>(Arrays.asList(str2));
                        //stringList.add(0,"testthucoi");
                        for (String str : stringList) {
                            String[] tungphantu = str.split(" ");

                            String[] soluongso = tungphantu[1].split("\\.");
                            daitinhtien = tungphantu[0];
                            if (daitinhtien.equals("2f")||daitinhtien.equals("1f")) {
                                for (int i = 2; i < tungphantu.length - 1; i = i + 2) {
                                    if (tungphantu[i].equals("ff")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 5;
                                    } else if (tungphantu[i].equals("b")) {
                                        for (String c : soluongso) {
                                            if (c.length() == 2)
                                                kq2c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 27;
                                            else if (c.length() == 3)
                                                kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 23;
                                            else if (c.length() == 4)
                                                kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 20;
                                        }
                                    } else if (tungphantu[i].equals("mm")) {
                                        for (String c : soluongso) {
                                            if (c.length() == 3) {
                                                if (c.substring(0, 1).equals(c.substring(1, 2)) || c.substring(0, 1).equals(c.substring(2, 3))
                                                        || c.substring(1, 2).equals(c.substring(2, 3))) {
                                                    sohoanvi = 3;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 23;
                                                } else {
                                                    sohoanvi = 6;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 23;
                                                }
                                            } else if (c.length() == 4) {
                                                int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
                                                a1 = Integer.parseInt(c.substring(0, 1));
                                                a2 = Integer.parseInt(c.substring(1, 2));
                                                a3 = Integer.parseInt(c.substring(2, 3));
                                                a4 = Integer.parseInt(c.substring(3, 4));
                                                if (((a1 == a2) && (a1 == a3)) || ((a1 == a2) && (a1 == a4)) || ((a2 == a3) && (a2 == a4))
                                                        || ((a1 == a3) && (a1 == a4))) {
                                                    sohoanvi = 4;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 20;
                                                } else if ((a1 != a2) && (a1 != a3) && (a1 != a4) && (a2 != a3) && (a2 != a4) && (a3 != a4)) //4con#
                                                {
                                                    sohoanvi = 24;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 20;
                                                } else if ((a1 == a2) && (a1 == a3) && (a1 == a4)) {
                                                    sohoanvi = 1;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 20;
                                                } else if ( ((a1==a2)&&(a1!=a3)&&(a1!=a4)&&(a2!=a3)&&(a2!=a4)&&(a3!=a4)) || ((a1!=a2)&&(a1==a3)&&(a1!=a4)&&(a2!=a3)&&(a2!=a4)&&(a3!=a4))
                                                        || ((a1!=a2)&&(a1!=a3)&&(a1==a4)&&(a2!=a3)&&(a2!=a4)&&(a3!=a4)) || ((a1!=a2)&&(a1!=a3)&&(a1!=a4)&&(a2==a3)&&(a2!=a4)&&(a3!=a4))
                                                        || ((a1!=a2)&&(a1!=a3)&&(a1!=a4)&&(a2!=a3)&&(a2==a4)&&(a3!=a4)) ||((a1!=a2)&&(a1!=a3)&&(a1!=a4)&&(a2!=a3)&&(a2!=a4)&&(a3==a4)) ){
                                                    sohoanvi = 12;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 20;
                                                } else {
                                                    sohoanvi = 6;
                                                    kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 20;
                                                }
                                            }
                                            sohoanvi = 0;
                                        }
                                    } else if (tungphantu[i].equals("kc")) {
                                        for (String c : soluongso) {
                                            kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 4;
                                        }
                                    } else if (tungphantu[i].equals("kk")) {

                                        for (String c : soluongso) {
                                            if (c.substring(0, 1).equals(c.substring(1, 2)) || c.substring(0, 1).equals(c.substring(2, 3))
                                                    || c.substring(1, 2).equals(c.substring(2, 3)))
                                                sohoanvi = 3;
                                            else sohoanvi = 6;

                                            kq3c += Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * sohoanvi * 4;
                                            sohoanvi = 0;
                                        }
                                        //kq+=soluongso.length * Float.parseFloat(tungphantu[i+1].substring(0,tungphantu[i+1].length()-1));

                                    } else if (tungphantu[i].equals("fc")||tungphantu[i].equals("ft")) {

                                        for (int d = 0; d < soluongso.length; d++)
                                            socap += d;
                                        kq2c += socap * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 2 * 27;
                                        socap = 0;
                                    } else if (tungphantu[i].equals("f")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 4;
                                    }
                                    else if (tungphantu[i].equals("fz")) {
                                        kq2c += soluongso.length * Float.parseFloat(tungphantu[i + 1].substring(0, tungphantu[i + 1].length())) * 1;
                                    }


                                }
                            }
                        }



                        //}
                        //catch   (Exception e1)
                        //    {
                        //        edt1.setError("Nhập sai");
                        //   }

                        //chuan hoa chuoi lai dung dinh dang ban dau
                        str2=chuanhoachuoi.split(",");
                        chuanhoachuoi="";
                        for (String test:str2)
                        {
                            //xoa chu n

                            test=test.replaceFirst("1f","1d");
                            test=test.replaceFirst("2f", "2d");

                            test=test.replaceAll("ff","dd");
                            test=test.replaceAll("fz","dui");
                            test=test.replaceAll("kk","xcd");

                            test=test.replaceAll("mm","bd");
                            test=test.replaceAll("fc","dc");

                            test=test.replaceAll("ft","dt");
                            test=test.replaceAll("kc","x");

                            test=test.replaceAll("f","d");

                            chuanhoachuoi+=test+",";
                        }
                        //edt2.setText(chuanhoachuoi+"\n"+"nhapsai");
                        str3= " hn 2c: "+Long.toString(kq2c)+"--hn 3c: "+Long.toString(kq3c);//+" "+chuanhoachuoi;
                        //str3= " 2c: "+Long.toString(kq2c)+"--3c: "+Long.toString(kq3c);
                        kq2c=0;
                        kq3c=0;
                        edt2.setText(chuanhoachuoi+"\n"+str3);
                        str3="";
                        chuanhoachuoi="";

                    }
                }

                //vi tri comment
            }
        });






        btndel=(Button)findViewById(R.id.btndel);
        btndel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                str1="";
                edt1.setText(str1);
            }
        });






    }
}
