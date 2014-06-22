import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class first {
	public static void main(String args[]) {
		final String FILE_NAME = "recipe-data.txt";
		String[] recipeList = null;
		final String[] USER_LIST = {"kou"};
		int inputId = -1;
		Map<String,String> recipeListOfUser = new HashMap<String,String>();

		System.out.println("���V�s��ID����͂��Ă�������: ");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			inputId = Integer.parseInt(input.readLine()); //FIXME �����ȊO����͂���Ɨ�O���N����
		} catch (IOException e1) {
			inputId = -1;
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
			for(String putString : recipeList)
			{
				recipeListOfUser.put(USER_LIST[0], putString);
			}

			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		/*���̓f�[�^�����X�g�ɑ��݂���ID�̏ꍇ��ID�ɑΉ����郌�V�s�ƁA�Ή�����URL��Ԃ�
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
