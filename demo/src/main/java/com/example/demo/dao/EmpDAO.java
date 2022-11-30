package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVO;

@Mapper
public interface EmpDAO {

/**
 * @Since : 2022. 11. 28.
 * @Author : mr.Hyun
 * @return : List<EmpVO>
 * @comment : EMP 테이블 전체 조회
 *
 */	
	List<EmpVO> selectEMP();
	
	/**
	 * @Since : 2022. 11. 29.
	 * @Author : mr.bin
	 * @return : List<DeptVO>
	 * @comment : DEPT 테이블 전체 조회
	 */	
	 List<DeptVO> selectDEPT();
	 
	 int insertEMP(EmpVO vo);
}
