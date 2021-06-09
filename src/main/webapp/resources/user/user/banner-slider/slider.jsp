<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
       <section id="aa-slider">
    <div class="aa-slider-area">
      <div id="sequence" class="seq">
        <div class="seq-screen">
          <ul class="seq-canvas">
            <!-- single slide item -->
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide-1.jpg" alt="Ảnh Banner BALO" />
              </div>
              <div class="seq-title">
               <span data-seq>Giảm giá lên đến 50%</span>                
                <h2 data-seq>Balo Thời Trang Cho Học Sinh</h2>                
                <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>
            <!-- single slide item -->
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide-2.jpg" alt="Ảnh Banner BALO" />
              </div>
              <div class="seq-title">
                <span data-seq>Giảm giá lên đến 20%</span>                
                <h2 data-seq>Balo du lịch cho tín đồ phượt</h2>                
                <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>
            <!-- single slide item -->
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide-3.jpg" alt="Ảnh Banner BALO" />
              </div>
              <div class="seq-title">
                <span data-seq>Giảm giá lên đến 33%</span>                
                <h2 data-seq>Balo dây rút thời trang</h2>                
                <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>
            <!-- single slide item -->           
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide-4.jpg" alt="Ảnh Banner BALO" />
              </div>
              <div class="seq-title">
                <span data-seq>Giảm giá lên đến 25%</span>                
                <h2 data-seq>Balo chống nước</h2>                
                <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>                   
          </ul>
        </div>
        <!-- slider navigation btn -->
        <fieldset class="seq-nav" aria-controls="sequence" aria-label="Slider buttons">
          <a type="button" class="seq-prev" aria-label="Previous"><span class="fa fa-angle-left"></span></a>
          <a type="button" class="seq-next" aria-label="Next"><span class="fa fa-angle-right"></span></a>
        </fieldset>
      </div>
    </div>
  </section>
