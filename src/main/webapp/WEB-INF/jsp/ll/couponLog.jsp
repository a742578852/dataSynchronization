<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        优惠券
        <span class="c-gray en">&gt;</span>
        优惠券发放记录
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">

            <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">


                      <script type="text/javascript">

        /*用户-编辑*/
        function csshenhe(title,url,id,w,h){
            layer_show(title,url,w,h);
        }
        </script>
				</span>


            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">

                        <th width="50">id</th>
                        <th width="50">用户昵称</th>
                        <th width="50">优惠券名</th>
                        <th width="50">优惠券编号</th>
                        <th width="50">使用情况</th>
                        <th width="50">使用时间</th>



                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${couponUser}" var="cou">
                        <tr class="text-c">
                            <td>${cou.ucId}</td>
                            <td>${cou.nickName}</td>
                            <td>${cou.couponName}</td>
                            <td>${cou.ucSn}</td>
                            <td>${cou.isUse}</td>
                            <td>${cou.isUseTime}</td>





                            <script type="text/javascript">


                            </script>
                        </tr>
                    </c:forEach>

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