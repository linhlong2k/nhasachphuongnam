<%@ page pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp" %>
<%@ include file="/resources/user/template/header.jsp" %>
  <!-- / header section -->
<!--  content -->
  <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
   <img style="height: 305px; width: 100%; object-fit: cover;" src="${pageContext.request.contextPath}/view/client/assets/images/banner-website.jpg" alt="banner sản phẩm">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Tin tức</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
          <li style="color:#fff">Tin tức</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- Blog Archive -->
  <section id="aa-blog-archive">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-blog-archive-area">
            <div class="row">
              <div class="col-md-12">
                <div class="aa-blog-content">
                  <div class="row">
                  <c:forEach items="${boardnewlist}" var="boardnew">
                    <div class="col-md-4 col-sm-4">
                      <article class="aa-blog-content-single">                        
                        <h4><a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}">${boardnew.title}</a></h4>
                        <figure class="aa-blog-img">
                          <a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/news/${boardnew.image_link}" alt="farm products" height="180px" width="300px"></a>
                        </figure>
                        <p class="desc-boardnews">${boardnew.content}</p>
                        <div class="aa-article-bottom">
                          <div class="aa-post-author">
                            Đăng bởi <a href="#">${boardnew.author}</a>
                          </div>
                          <div class="aa-post-date">${boardnew.created}</div>
                        </div>
                      </article>
                    </div>
                    </c:forEach>
                  </div>
                </div>
                <!-- Blog Pagination -->
               
              </div>
             
            </div>
          </div>
        </div>
      </div>
	</div>
  </section>
  <!-- / Blog Archive -->

<!--  end content-->
<!--  footer-->
<%@ include file="/resources/user/template/footer.jsp" %>
<!-- end footer-->
  
  
