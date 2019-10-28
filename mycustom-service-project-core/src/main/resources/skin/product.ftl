<@extends src="base.ftl">
  <@block name="title">Product Price</@block>
  <@block name="header">
    	Price of the product : ${productId}
  </@block>
  <@block name="content">
  		<#if price>
  			Price = ${price}
  		<#else>
  			No price available
  		</#if>	
    This is the <i>index1</i> skin.
  </@block>
  <@block name="footer">
    The footer here ...
  </@block>
</@extends>