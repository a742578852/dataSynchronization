<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        仓库
        <span class="c-gray en">&gt;</span>
        仓库信息
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <form action="/web/goStock" method="post"id="form">
                <input type="hidden" id="currentPage" name="currentPage">

                <div class="text-c">






                    商品编号:
                    <input type="text" name="goodsSn" style="width:120px" value="${goodsSn}" class="input-text">
                    &nbsp;&nbsp;&nbsp;




                    <button name=""  class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
                </div>
            </form>

            <div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">


                      <script type="text/javascript">
                          function getCab() {
                              var options=$("#neigh option:selected"); //获取选中的项
                              var id = options.val()
                              $.ajax({
                                  data:{"neighId":id},
                                  type:"post",
                                  dataType:"json",
                                  url:"${pageContext.request.contextPath}/web/getCabinet",
                                  success:function(data){
                                      $("#cabinet").html("")
                                      var len=data.length;
                                      for(var i=0;i<len;i++){
                                          var option=document.createElement("option");
                                          $("#cabinet").append(('<option value='+data[i].cabinetid+'>'+data[i].cabinet+'</option>'));
                                      }
                                  },
                                  error:function(data){
                                      console.log(data);
                                  }
                              });

                          }

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

                        <th width="60">商品编号</th>
                        <th width="200">商品名</th>
                        <th width="200">仓库</th>
                        <th width="50">库存</th>
                        <th width="50">操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${stockGoods}" var="stock">
                        <tr class="text-c">

                            <td>${stock.goodsSn}</td>
                            <td>${stock.goodsName}</td>
                            <td>${stock.wId}</td>
                            <td>${stock.goodsNumber}</td>

                            <td>
                                <a style="text-decoration:none" class="ml-5" href="${pageContext.request.contextPath}/web/goStockUpdate?stockId=${stock.stocksgoodsId}"    title="修改"><i class="Hui-iconfont">&#xe6df;</i></a>

                            </td>


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