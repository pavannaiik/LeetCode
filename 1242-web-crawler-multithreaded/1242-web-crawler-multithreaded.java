/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    private Set<String>set;
    private String host;
    private HtmlParser htmlParser;
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        set = ConcurrentHashMap.newKeySet();
        host = getUrl(startUrl);
        this.htmlParser = htmlParser;
        crawlR(startUrl);
        return new ArrayList<>(set);
    }
    public void crawlR(String url){
        if(set.contains(url) ||! host.equals(getUrl(url))) return;
        set.add(url);
        htmlParser.getUrls(url).parallelStream().forEach(this::crawlR);
    }
    public String getUrl(String startUrl){
        int end = startUrl.indexOf("/",7);
        return startUrl.substring(7,end==-1?startUrl.length():end);
    }
}