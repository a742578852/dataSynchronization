<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">

            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">

                        <th width="50">商品编号</th>
                        <th width="50">商品id</th>
                        <th width="50">商品名</th>
                        <th width="50">商品价格</th>
                        <th width="50">商品数量</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orderGoods}" var="order">
                        <tr class="text-c">

                            <td>${order.goodsSn}</td>
                            <td>${order.goodsId}</td>
                            <td>${order.goodsName}</td>
                            <td>${order.goodsPrice}</td>
                            <td>${order.goodsNumber}</td>

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