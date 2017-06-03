package Model;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Time {
    private int HH;
    private int MM;
    private int SS;
public Time(int hh, int mm, int ss) {
        HH = hh;
        MM = mm;
        SS = ss;
        }


public void setHH(int hH) {
        HH = hH;
        }

public int getMM() {
        return MM;
        }

public void setMM(int mM) {
        MM = mM;
        }

public int getSS() {
        return SS;
        }

public void setSS(int sS) {
        SS = sS;
        }


public String toString() {
        return ""+HH+":"+MM+":"+SS;
        }
}
