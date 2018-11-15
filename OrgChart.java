import java.util.*;


class Wrapper {

    List<String> lst;
    String name;
    String dash;
   
    public Wrapper(List<String> lst, String name, String dash) {
	this.lst = lst;
	this.name = name;
	this.dash = dash;
    }

}

/**

   Point is to take in a string of names with "id:name:manager_id" and print out the org chart

 */
public class OrgChart {

    public OrgChart() {
       
    }

    public void printOrgChart(String str) {
	String[] people = str.split(",");
	
	HashMap<String, String> parents = new HashMap<String, String>();
	HashMap<String, List<String>> children = new HashMap<String, List<String>>();
	HashMap<String, String> nameMap = new HashMap<String, String>();

	for (String p: people) {
	    String[] elems = p.split(":");
	    String id = elems[0];
	    String name = elems[1];
	    String manager = elems[2];

	    parents.put(id, manager+","+name);
	    nameMap.put(id, name);

	    List<String> lst = new ArrayList<String>();
	    if (children.containsKey(manager)) {
		lst = children.get(manager);
	    }
	    lst.add(id);
	    children.put(manager, lst);
	}

	List<String> root = children.get("0");
	Stack<Wrapper> que = new Stack<Wrapper>();
	que.add(new Wrapper(root, "", ""));
	while (que.size() > 0) {
	    Wrapper wrap = que.pop();
	    List<String> links = wrap.lst;
	    String n = wrap.name;
	    String d = wrap.dash;
	    for (String key: links) {
		System.out.println(d+" "+nameMap.get(key));
		if (children.containsKey(key)) {
		    que.push(new Wrapper(children.get(key), key, d+"-"));
		}
	    }
	}
    }

    public static void main(String[] args) {
	OrgChart org = new OrgChart();
	String str = "1:Max:4,2:Ann:0,4:Edmund:2,3:Jake:2";
	org.printOrgChart(str);
	str = "1:Max:4,2:Ann:0,4:Edmund:2,3:Jake:2,5:Joo:3";
	org.printOrgChart(str);
    }

}