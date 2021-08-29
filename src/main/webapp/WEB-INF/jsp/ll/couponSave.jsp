<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        优惠券
        <span class="c-gray en">&gt;</span>
        优惠券发放
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <form action="/web/toCounponSave" method="post"id="form">
                <input type="hidden" id="currentPage" name="currentPage">

                <div class="text-c">
                    日期范围：
                    <input step="1" type="datetime-local" name="startTime"  id="startTime" class="input-text Wdate" style="width:210px;" value="${startTime}">
                    -
                    <input step="1" type="datetime-local" name="endTime"  id="endTime" class="input-text Wdate" style="width:210px;" value="${endTime}">
                    &nbsp;&nbsp;&nbsp;


                    订单编号:
                    <input type="text" name="orderSn" style="width:120px" value="${orderSn}" class="input-text">
                    &nbsp;&nbsp;&nbsp;
                    <br/>
                    联系人:
                    <input type="text" name="userName" style="width:120px" value="${userName}" class="input-text">
                    &nbsp;&nbsp;&nbsp;

                    联系电话:
                    <input type="text" name="mobile" style="width:120px" value="${mobile}" class="input-text">
                    &nbsp;&nbsp;&nbsp;
                    <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
                </div>
            </form>

            <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">


                      <script type="text/javascript">


        /*用户-编辑*/
        function csshenhe(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
        </script>
				</span>

                <span class="r">共有订单：<strong>${count}</strong> 条</span>
                <br/>

            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">

                        <th width="60">订单编号</th>
                        <th width="50">联系人</th>
                        <th width="50">联系电话</th>
                        <th width="50">小区</th>
                        <th width="50">自提柜编号</th>
                        <th width="50">详细地址</th>
                        <th width="50">订单金额</th>
                        <th width="50">创建时间</th>
                        <th width="50">付款时间</th>
                        <th width="50">订单状态</th>
                        <th width="40">赠送优惠券</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderInfos.lists}" var="order">
                        <tr class="text-c">

                            <td>${order.orderSn}</td>
                            <td>${order.consignee}</td>
                            <td>${order.mobile}</td>
                            <td>${order.neighbourhoodid}</td>
                            <td>${order.cabinetid}</td>
                            <td>${order.address}</td>
                            <td>${order.goodsAmount}元</td>
                            <td>${order.addTime}</td>
                            <td>${order.payTime}</td>
                            <td>

                                    <c:if test="${order.orderStatus == 0}">
                                        <span style="color: red">
                                        未确认
                                             </span>
                                    </c:if>
                                    <c:if test="${order.orderStatus == 1}">
                                        <span style="color: green">
                                            已确认
                                        </span>
                                    </c:if>
                                <c:if test="${order.shippingStatus == 0}">
                                    <span style="color: red">未发货</span>
                                </c:if>
                                <c:if test="${order.shippingStatus == 1}">
                                    <span style="color: yellow">已存柜</span>
                                </c:if>
                                <c:if test="${order.shippingStatus == 2}">
                                    <span style="color: green">已收货</span>
                                </c:if>
                                <c:if test="${order.payStatus == 0}">
                                    <span style="color: red">未付款</span>
                                </c:if>
                                <c:if test="${order.payStatus == 1}">
                                    <span style="color: yellow">付款中</span>
                                </c:if>
                                <c:if test="${order.payStatus == 2}">
                                    <span style="color: green">已付款</span>
                                </c:if>
                                <c:if test="${order.refundStatus == -1}">
                                    <span style="color: red">已拒绝</span>
                                </c:if>
                                <c:if test="${order.refundStatus == 0}">
                                    <span style="color: green">未申请</span>
                                </c:if>
                                <c:if test="${order.refundStatus == 1}">
                                    <span style="color: yellow">已申请</span>
                                </c:if>
                                <c:if test="${order.refundStatus == 2}">
                                    <span style="color: #00B83F">已通过</span>
                                </c:if>
                            </td>
                            <td>
                                <a style="text-decoration:none" class="ml-5" href="${pageContext.request.contextPath}/web/couponSave?userid=${order.userId}&orderSn=${order.orderSn}"    title="详情"><i class="Hui-iconfont">&#xe6df;</i></a>

                            </td>


                            <script type="text/javascript">


                            </script>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            <a href="javascript:jump('1')">首页</a>
                            <a href="javascript:jump(${orderInfos.currentPage-1})">上一页</a>
                            <a href="javascript:jump(${orderInfos.currentPage+1})">下一页</a>
                            <a href="javascript:jump(${orderInfos.totalPage})">末页</a>
                            跳转至:<input type="text" id="page"><input type="button" id="btn" value="跳转">
                            当前${orderInfos.currentPage}/${orderInfos.totalPage}页
                        </td>
                        <script type="text/javascript">
                            function jump(page){
                                $("#currentPage").val(page);
                                $("#form").submit();
                            }
                            $("#btn").click(function () {
                                var p = $("#page").val();
                                $("#currentPage").val(p);
                                $("#form").submit();
                            })
                        </script>
                    </tr>
                    </tbody>
                </table>
            </div>
        </article>
    </div>
    <script type="text/javascript">
        /*用户-编辑*/
        function caidingming(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
        function caishen(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
    </script>
</section>
<%@include file="../footer.jsp"%>