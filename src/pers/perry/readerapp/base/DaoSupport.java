package pers.perry.readerapp.base;

import java.util.List;

public interface DaoSupport<T> {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 根据id查询一个
	 * @param id
	 * @return
	 */
	public T getById(Integer id);

	/**
	 * 根据id查询多个
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Integer[] ids);

	/**
	 * 查询最大的id(主键)
	 * @return
	 */
	public Integer getMaxId();
	
	/**
	 * 增加
	 * @param entity
	 * @return TODO
	 */
	public boolean save(T entity);

	/**
	 * 删除
	 * @param entity
	 * @return TODO
	 */
	public boolean delete(Integer id);

	/**
	 * 更新
	 * @param entity
	 * @return TODO
	 */
	public boolean update(T entity);

}
