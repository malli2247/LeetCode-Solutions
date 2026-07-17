class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
  String str = preprocess(paragraph);
  String[] words = str.split("\\s+"); // split by one or more spaces
  // ban set
  Set<String> banSet = new HashSet<>();
  for (String s : banned) banSet.add(s);
  // count map
  Map<String, Integer> countMap = new HashMap<>();
  int maxCount = 0;
  for (String s : words) {
    if (banSet.contains(s)) continue;
    int count = countMap.getOrDefault(s, 0) + 1;
    maxCount = Math.max(maxCount, count);
    countMap.put(s, count);
  }
  // find the string with maxCount
  for (String s : countMap.keySet()) {
    if (countMap.get(s) == maxCount) {
      return s;
    }
  }
  return null;
}
// "a, a, a, a, b,b,b,c, c"
// ["a"]
// Output: "b"
private String preprocess(String s) {
  s = s.replace("!", " "); // for "a,a,a,,a", we should replace by " " instead of ""
  s = s.replace("?", " ");
  s = s.replace("'", " ");
  s = s.replace(",", " ");
  s = s.replace(";", " ");
  s = s.replace(".", " ");
  s = s.trim();  // should be put after all those replace()
  s = s.toLowerCase();
  return s;
}
}