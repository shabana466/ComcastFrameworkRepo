package practice_listeners1;

import java.util.Date;

public class CaptureTimeeStamp {

	public static void main(String[] args) {
		String time=new Date().toString().replace(" ","_").replace(":","_");
		System.out.println(time);

	}

}
