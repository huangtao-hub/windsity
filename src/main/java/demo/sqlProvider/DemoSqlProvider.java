package demo.sqlProvider;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import demo.entity.DemoEntity;

/**
 * 拼装语句
 */
public class DemoSqlProvider {
	
	public String addOne() {
		String sql = "INSERT INTO DEMO (name, intro) VALUES (#{name}, #{intro})";
        return sql;
	}
	
	/**
	 * 拼装出来
	 * INSERT INTO DEMO (name, intro) VALUES 
	 * (#{list[0].name},#{list[0].intro}),(#{list[1].name},#{list[1].intro}),(#{list[2].name},#{list[2].intro})
	 * @param map
	 * @return
	 */
	public String addList(Map<String, List<DemoEntity>> map) {
		List<DemoEntity> demolist = map.get("list");
		StringBuffer sql = new StringBuffer("INSERT INTO DEMO (name, intro) VALUES ");
		MessageFormat mf = new MessageFormat("(#'{'list[{0}].name},#'{'list[{0}].intro})");  
		int len = demolist.size();
		int len1 = len - 1;
        for (int i = 0; i < len; i++) {  
        	sql.append(mf.format(new Object[]{i}));  
            if (i < len1) {  
            	sql.append(",");  
            }  
        }  
        System.out.println(sql.toString());
        return sql.toString();  
	}
	
	public String modify() {
		String sql = "UPDATE DEMO SET name=#{name}, intro=#{intro} WHERE id=#{id}";
        return sql;  
	}
	
	public String remove() {
		String sql = "DELETE FROM DEMO WHERE id=#{id}";
        return sql;  
	}
	
	public String removeIn(Map<String, List<Integer>> map) {
		List<Integer> ids = map.get("list");
		StringBuffer sql = new StringBuffer("DELETE FROM DEMO WHERE id in ( ");
		MessageFormat mf = new MessageFormat("#'{'list[{0}]}"); 
		int len = ids.size();
		int len1 = len - 1;
		for (int i = 0; i < len; i++) {  
        	sql.append(mf.format(new Object[]{i}));  
            if (i < len1) {  
            	sql.append(",");  
            }  
        }  
		sql.append(")");  
		System.out.println(sql.toString());
        return sql.toString();  
	}

	public String queryOne() {
		String sql = "SELECT ID,NAME,INTRO FROM DEMO WHERE id=#{id}";
        return sql;  
	}
	
	public String queryList() {
		String sql = "SELECT ID,NAME,INTRO FROM DEMO WHERE NAME=#{name}";
        return sql;  
	}
	
	public String queryPage(Map<String, Object> map) {
		StringBuffer sql = pageSql(map);
		sql.append(" LIMIT #{pager.startNo},#{pager.size}");
		System.out.println(sql.toString());
        return sql.toString();  
	}
	
	public String count(Map<String, Object> map) {
		String sql = "SELECT COUNT(1) FROM ("+pageSql(map)+") A";
        return sql.toString();  
	}
	
	private StringBuffer pageSql(Map<String, Object> map){
		@SuppressWarnings("unchecked")
		List<Integer> ids = (List<Integer>) map.get("ids");
		
		StringBuffer sql = new StringBuffer("SELECT id,name,intro FROM DEMO WHERE NAME=#{name} AND id IN ( ");
		MessageFormat mf = new MessageFormat("#'{'ids[{0}]}"); 
		int len = ids.size();
		int len1 = len - 1;
		for (int i = 0; i < len; i++) {  
        	sql.append(mf.format(new Object[]{i}));  
            if (i < len1) {  
            	sql.append(",");  
            }  
        }  
		sql.append(")"); 
		return sql;
	}
}
