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

		System.out.println("レシピのIDを入力してください: ");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			inputId = Integer.parseInt(input.readLine()); //FIXME 数字以外を入力すると例外が起きる
		} catch (IOException e1) {
			inputId = -1;
		}

		// ファイルを読んでレシピリストを作成
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

		/*入力データがリストに存在するIDの場合はIDに対応するレシピと、対応するURLを返す
		 * それ以外の場合はすべてのレシピリストを返す
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
