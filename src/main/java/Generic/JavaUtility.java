package Generic;

import java.util.Random;

public class JavaUtility {

	public int getRandomNum(int num) {
		Random ran = new Random();
		int randomNum = ran.nextInt(num);
		return randomNum;
}
}