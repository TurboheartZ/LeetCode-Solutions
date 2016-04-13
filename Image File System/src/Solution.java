import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "dir1\n dir2\n  dir3\n   dir4\n   pic.jpeg\n   picture.png\n";
		System.out.println(input);
		System.out.println(imageFile(input));
	}
	public static int imageFile(String s){
		int dirLength = 0;
		int maxLength = 0;
		String[] dirs = s.split("\\n");
		Stack<String> paths = new Stack<String>();
		for(int i = 0; i<dirs.length; i++){
			int nextLevel = dirLevel(dirs[i]);
			while(paths.size()-1>=nextLevel){
				dirLength -= paths.pop().length();
			}
			paths.push("/"+dirs[i].substring(nextLevel, dirs[i].length()));
			dirLength += dirs[i].length()-nextLevel+1;
			if(isImage(dirs[i])==true){
				maxLength = Math.max(maxLength, dirLength);
				continue;
			}
		}
		System.out.println(paths);
		return maxLength;
	}
	private static boolean isImage(String file){
		boolean result = false;
		if(file.contains(".jpeg")||file.contains(".png")||file.contains(".gif")){
			result = true;
		}
		return result;
	}
	private static int dirLevel(String dir){
		//We can check the directory level through counting the white space in the front
		int level = 0;
		for(level = 0; level<dir.length(); level++){
			if(dir.charAt(level)!=' '){
				break;
			}
		}
		return level;
	}
}
