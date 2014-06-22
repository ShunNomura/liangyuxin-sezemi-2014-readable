import java.awt.SplashScreen;
import java.io.*;

public class first {
	public static void main(String args[]) {
		final String FILE_NAME = "recipe-data.txt";
		String[] recipeList = null;
		int inputId = -1;

		System.out.println("���V�s��ID����͂��Ă�������: ");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			inputId = Integer.parseInt(input.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// �t�@�C����ǂ�Ń��V�s���X�g���쐬
		try {
			File file = new File(FILE_NAME);
			FileReader filereader = new FileReader(file);

			int ch;
			String recipeString = "";
			while ((ch = filereader.read()) != -1) {
				recipeString += (char) ch;
			}
			recipeList = recipeString.split("\n");

			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		/*���̓f�[�^�����X�g�ɑ��݂���ID�̏ꍇ��ID�ɑΉ����郌�V�s��Ԃ�
		 * ����ȊO�̏ꍇ�͂��ׂẴ��V�s���X�g��Ԃ�
		 */
		if (inputId > 0 && inputId <= recipeList.length) {
			System.out.println(inputId + ": " + recipeList[inputId-1]);
		} else {
			for (int i = 0; i < recipeList.length; i++) {
				System.out.println(i + 1 + ": " + recipeList[i]);
			}
		}
		
		
	}
}
