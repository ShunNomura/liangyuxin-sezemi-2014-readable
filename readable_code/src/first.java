import java.awt.SplashScreen;
import java.io.*;

public class first {
	public static void main(String args[]) {
		final String FILE_NAME = "recipe-data.txt";
		String[] recipeList = null;
		int inputId = -1;

		System.out.println("レシピのIDを入力してください: ");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			inputId = Integer.parseInt(input.readLine());
		} catch (IOException e1) {
			e1.printStackTrace();
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

			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		/*入力データがリストに存在するIDの場合はIDに対応するレシピを返す
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
