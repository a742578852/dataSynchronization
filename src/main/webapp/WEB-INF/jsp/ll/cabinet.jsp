<%@include file="../head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        柜体
        <span class="c-gray en">&gt;</span>
        柜体信息
    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <form action="/web/toCabinet" method="post"id="form">
                <input type="hidden" id="currentPage" name="currentPage">

                <div class="text-c">

                    小区:
                    <select style="width:120px;height: auto" class="input-text" name="neighId" id="neigh" onclick="getCab()">
                        <option value="${neigh.neighbourhoodid}">${neigh.neighbourhood}</option>
                        <option value="">请选择</option>
                        <c:forEach items="${neight}" var="neight">
                            <option value="${neight.neighbourhoodid}">${neight.neighbourhood}</option>
                        </c:forEach>

                    </select>
                    &nbsp;&nbsp;&nbsp;
                    柜子:
                    <select style="width:120px;height: auto" class="input-text" name="cabinetId" id="cabinet">
                        <option value="${cabinet.cabinetid}">${cabinet.cabinet}</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;

                    是否启用:
                    <select style="width:120px;height: auto" class="input-text" name="enable" id="enable">
                        <option value="${enable}">${enable}</option>
                        <option value="Y">Y</option>
                        <option value="N">N</option>
                    </select>
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

                <span class="r">共有柜子：<strong>${count}</strong> 个</span>
                <br/>

            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort">
                    <thead>
                    <tr class="text-c">

                        <th width="60">小区编号</th>
                        <th width="50">自提柜编号</th>
                        <th width="50">自提柜名</th>
                        <th width="50">空置数</th>
                        <th width="50">经度</th>
                        <th width="50">纬度</th>
                        <th width="50">是否启用</th>
                        <th width="50">柜格详情</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cabinets.lists}" var="cabinet">
                        <tr class="text-c">

                            <td>${cabinet.neighbourhoodid}</td>
                            <td>${cabinet.cabinetid}</td>
                            <td>${cabinet.cabinet}</td>
                            <td>${cabinet.freeNum}</td>
                            <td>${cabinet.longitude}</td>
                            <td>${cabinet.latitude}</td>
                            <td>${cabinet.enable}</td>

                            <td>
                                <a style="text-decoration:none" class="ml-5" href="${pageContext.request.contextPath}/web/goCabCell?cabinetId=${cabinet.cabinetid}"    title="详情"><i class="Hui-iconfont">&#xe6df;</i></a>

                            </td>


                            <script type="text/javascript">


                            </script>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5">
                            <a href="javascript:jump('1')">首页</a>
                            <a href="javascript:jump(${cabinets.currentPage-1})">上一页</a>
                            <a href="javascript:jump(${cabinets.currentPage+1})">下一页</a>
                            <a href="javascript:jump(${cabinets.totalPage})">末页</a>
                            跳转至:<input type="text" id="page"><input type="button" id="btn" value="跳转">
                            当前${cabinets.currentPage}/${cabinets.totalPage}页
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