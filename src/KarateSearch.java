public class KarateSearch {
	public int chop(int x, int[] array) {
		return chopDivide(0, array.length-1, x, array);
	}

	public int chopDivide(int begin, int end, int element, int[] array) {
			if (begin == end) {
				if (array[begin] == element) {
					return begin;
				} else {
					return -1;
				}
			} else {
				int middle = (int) Math.ceil(((end + begin) / 2));
				System.out.println("middle = " + middle);
				if (element > array[middle]) {
					System.out.println("right");
					return chopDivide(middle + 1, end, element, array);
				} else {
					System.out.println("left");
					return chopDivide(begin, middle, element, array);
				}

			}

		
	}
}
