<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${modelClassDesc.packgeName}.dao.${modelClassDesc.className}DaoImpl">
	<resultMap id="m${modelClassDesc.className}" type="${modelClassDesc.className}">
		<#list modelClassDesc.fileds as filed> 
			<result column="${filed.tableFiledName}" property="${filed.filedName}" />
		</#list> 
	</resultMap>

	<!-- 表名 -->
	<sql id="tableNameSql">
		${modelClassDesc.tableName}
	</sql>

	<!-- 用于select查询、insert的公用抽取的列 -->
	<sql id="commonSelectColumnsPrefix">
			${modelClassDesc.tableFieldString}
	</sql>
	<!-- 按主键查找条件语句 -->
	<sql id="conditionOnlyId">
		id = ${r"#{id}"}
	</sql>
	
	<sql id="mainSql">
		SELECT
			<include refid="commonSelectColumnsPrefix"/>
		FROM
			<include refid="tableNameSql"/>
	</sql>

	<sql id="varSql">
		<where>
				<#list modelClassDesc.fileds as filed> 
					<if test="@Ognl@isNotEmpty(${filed.filedName})">
						AND ${filed.tableFiledName} = ${r"#{"}${filed.filedName}${r"}"}
					</if>
				</#list> 
		</where>
	</sql>

	<select id="findPageBy" parameterType="java.util.Map" resultMap="m${modelClassDesc.className}">
 		<include refid="mainSql"/>
 		<include refid="varSql"/>
		<if test="@Ognl@isNotEmpty(sortColumns)">
			order by ${r"${sortColumns}"}
		</if>
		<if test="@Ognl@isNotEmpty(page)">
				${r"${page}"}
		</if>
	</select>

	<select id="getById" parameterType="String" resultMap="m${modelClassDesc.className}">
		<include refid="mainSql"/>
		where <include refid="conditionOnlyId"/>
	</select>

	<select id="getCountBy" parameterType="java.util.Map" resultType="INTEGER">
		SELECT
			COUNT(*)
		FROM
			<include refid="tableNameSql"/>
		<include refid="varSql"/>
	</select>

	<select id="findListBy" parameterType="java.util.Map" resultMap="m${modelClassDesc.className}">
		<include refid="mainSql"/>
		<include refid="varSql"/>
	</select>

	<insert id="save" parameterType="${modelClassDesc.className}">
		insert into
			<include refid="tableNameSql"/>
		(
			<include refid="commonSelectColumnsPrefix"/>
		)
		values
		(
			<#list modelClassDesc.fileds as filed> 
				${r"#{"}${filed.filedName}${r"}"},
			</#list> 
			
		)
	</insert>

	<update id="update" parameterType="${modelClassDesc.className}">
		update
			<include refid="tableNameSql"/>
		set
		<#list modelClassDesc.fileds as filed> 
				${filed.tableFiledName} = ${r"#{"}${filed.filedName}${r"}"},
		</#list> 
		where <include refid="conditionOnlyId"/>
	</update>
	<delete id="deleteByIds" parameterType="list">
		delete from <include refid="tableNameSql"/> 
		where id in <foreach index="index" item="item" collection="array" separator="," open="(" close=")" >${r"#{item}"}</foreach>
	</delete>

	<delete id="deleteById" parameterType="Object">
		delete from <include refid="tableNameSql"/> where <include refid="conditionOnlyId"/>
	</delete>

</mapper>