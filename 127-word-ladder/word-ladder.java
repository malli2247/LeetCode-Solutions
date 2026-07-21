class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[i] = c;
                        String next = new String(arr);

                        if (next.equals(endWord))
                            return level + 1;

                        if (dict.contains(next)) {
                            queue.offer(next);
                            dict.remove(next);
                        }
                    }

                    arr[i] = original;
                }
            }

            level++;
        }

        return 0;
    }
}