package com.ybd.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring/spring-context" })
public class TestMapperTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 执行测试方法之前
	 */
	@Before
	public void init() {
		String test = "init";
		assertEquals("init", test);
		assertTrue(test.equals("init"));
		logger.info(" test init ");
	}

	/**
	 * 执行测试方法之后
	 */
	@After
	public void end() {
		logger.info(" test end ");
	}

	@Test
	public void testPager() {
		Page<?> page = PageHelper.startPage(1, 2); // 核心分页代码
		// Page<?> page = PageHelper.startPage(1, -1); // 统计总数，（将SQL语句变为 select
		// count(0) from
		// xxx,只对简单SQL语句其效果，复杂SQL语句需要自己写）
		// PageHelper.startPage(1,0); //查询所有数据
		// List<?> list = demoMapper.selectAll(); //查询请求列表数据
		List<?> list = new ArrayList();
		long count = page.getTotal();
		logger.info("count:" + count);
		// List<AreaBranches> list = areaMapper.selectProvinces();
		logger.info("list:" + list.size() + "data:"
				+ JSONArray.toJSONString(list));
	}

}
