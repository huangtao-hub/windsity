package demo.dao;

import demo.entity.DemoEntity;
import demo.entity.Pager;
import demo.entity.PlanDayEntity;
import demo.sqlProvider.DemoSqlProvider;
import demo.sqlProvider.LoginSqlProvider;
import demo.sqlProvider.PlanSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mybatis可以通过注解的形式直接生成动态sql。
 */
public interface PlanDaoMapper {


	/**
	 * DemoSqlProvider类中的insertOne方法返回sql语句，参数对应demoEntity实体中的属性值
	 * @SelectKey 返回了插入后的主键id值赋值给实体demoEntity.id
	 * @param
	 * @return 插入成功条数
	 */
	@InsertProvider(type= PlanSqlProvider.class,method="planaddDay")
	@SelectKey(statement="SELECT LAST_INSERT_ID() AS ID", keyProperty="id", before=false, resultType=int.class)
	int planaddDay(PlanDayEntity planDayEntity);


	/**
	 * DemoSqlProvider类中的insertOne方法返回sql语句，参数对应demoEntity实体中的属性值
	 * @SelectKey 返回了插入后的主键id值赋值给实体demoEntity.id
	 * @param
	 * @return 插入成功条数
	 */
	@SelectProvider(type= LoginSqlProvider.class,method="loginuser")
	String loginuser(String username);










	/**
	 * DemoSqlProvider类中的insertOne方法返回sql语句，参数对应demoEntity实体中的属性值
	 * @SelectKey 返回了插入后的主键id值赋值给实体demoEntity.id
	 * @param demoEntity
	 * @return 插入成功条数
	 */
	@InsertProvider(type=DemoSqlProvider.class,method="addOne")
//	@Options(flushCache = true, timeout = 20000)
	@SelectKey(statement="SELECT LAST_INSERT_ID() AS ID", keyProperty="id", before=false, resultType=int.class)
	int addOne(DemoEntity demo);

	/**
	 * emoSqlProvider类中的insertList方法返回sql语句，参数对应demoEntity实体中的属性值
	 * @param demolist
	 * @return
	 */
	@InsertProvider(type=DemoSqlProvider.class,method="addList")
	//刷新缓存
	@Options(flushCache = true, timeout = 20000)
	int addList(List<DemoEntity> demolist);

	/**
	 * 同插入
	 * @param demo
	 * @return
	 */
	@UpdateProvider(type=DemoSqlProvider.class,method="modify")
	@Options(flushCache = true, timeout = 20000)
	int modify(DemoEntity demo);

	/**
	 * 同插入
	 * @param id
	 * @return
	 */
	@DeleteProvider(type=DemoSqlProvider.class,method="remove")
	@Options(flushCache = true, timeout = 20000)
	int remove(int id);

	/**
	 * 同插入
	 * @param ids
	 * @return
	 */
	@DeleteProvider(type=DemoSqlProvider.class,method="removeIn")
	@Options(flushCache = true, timeout = 20000)
	int removeIn(List<Integer> ids);

	/**
	 * 存在多条时报错，不存在时null
	 * @param id
	 * @return
	 */
	@SelectProvider(type=DemoSqlProvider.class,method="queryOne")
	DemoEntity queryOne(int id);

	/**
	 * 返回数组，不存在为空数组
	 * @param name
	 * @return
	 */
	@SelectProvider(type=DemoSqlProvider.class,method="queryList")
	List<DemoEntity> queryList(String name);

	@SelectProvider(type=DemoSqlProvider.class,method="queryPage")
	List<DemoEntity> queryPage(@Param("ids") List<String> ids, @Param("name") String name, @Param("pager") Pager<DemoEntity> pager);

	@SelectProvider(type=DemoSqlProvider.class,method="count")
	int count(@Param("ids") List<String> ids, @Param("name") String name);

}
