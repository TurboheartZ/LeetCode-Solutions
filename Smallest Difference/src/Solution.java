import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		int[] nums1 = {1,3,15,11,2};
		int[] nums2 = {23,127,235,9,16,19,8};
		Pair result = minDiff(nums1,nums2);
		System.out.printf("(%d,%d)",result.x,result.y);
	}
	public static Pair minDiff(int[] nums1, int[] nums2){
		Pair result = new Pair(0,0);
		int len1 = nums1.length;
		int len2 = nums2.length;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		if(nums1[len1-1]<=nums2[0]){
			result.x = nums1[len1-1];
			result.y = nums2[0];
			return result;
		}
		else if(nums2[len1-1]<=nums1[0]){
			result.x = nums2[len1-1];
			result.y = nums1[0];
			return result;
		}
		else{
			int p1 = 0;
			int p2 = 0;
			int diff = Integer.MAX_VALUE;
			while(p1<len1&&p2<len2){
				if(nums1[p1]<=nums2[p2]){
					if(nums2[p2]-nums1[p1]<diff){
						diff = nums2[p2]-nums1[p1];
						result.x = nums1[p1];
						result.y = nums2[p2];
					}
					p1++;
				}
				else{//nums1[p1]>nums2[p2]
					if(nums1[p1]-nums2[p2]<diff){
						diff = nums1[p1]-nums2[p2];
						result.x = nums1[p1];
						result.y = nums2[p2];
					}
					p2++;
				}
			}
			return result;
		}	
	}
}
