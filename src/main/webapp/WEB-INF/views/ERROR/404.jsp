<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi" class="fa-events-icons-ready">

<head>
		<!-- set Icon browser -->
  	<link rel="icon" href="resources/images/logo.png">
    <base href="${pageContext.servletContext.contextPath }/">
    <base href="${pageContext.request.contextPath }/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Thông báo!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="keywords" content="VNPT E-Learning">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }

        if (window.self !== window.top) {
            if (document.getElementById('back-to-home'))
                document.getElementById('back-to-home').style.display = 'none'
        }
    </script>
    <link href="resources/ERROR/css.css" rel="stylesheet">
    <link href="resources/ERROR/style.css" rel="stylesheet" type="text/css" media="all">
    <script src="resources/ERROR/4091b4eae6.js.download"></script>
    <link href="resources/ERROR/4091b4eae6.css" media="all" rel="stylesheet">
    <script>
        var errorCode = "";
    </script>
    <style type="text/css" data-styled-components="FiaaB gTcftA caPIRE" data-styled-components-is-local="true">
        @-webkit-keyframes FiaaB {
            100% {
                -webkit-transform: rotate(360deg);
                -ms-transform: rotate(360deg);
                transform: rotate(360deg);
            }

        }

        @keyframes FiaaB {
            100% {
                -webkit-transform: rotate(360deg);
                -ms-transform: rotate(360deg);
                transform: rotate(360deg);
            }

        }

        @-webkit-keyframes gTcftA {

            10%,
            90% {
                -webkit-transform: translate3d(-1px, 0, 0);
                -ms-transform: translate3d(-1px, 0, 0);
                transform: translate3d(-1px, 0, 0);
            }

            20%,
            80% {
                -webkit-transform: translate3d (2px, 0, 0);
                -ms-transform: translate3d (2px, 0, 0);
                transform: translate3d (2px, 0, 0);
            }

            30%,
            50%,
            70% {
                -webkit-transform: translate3d (-4px, 0, 0);
                -ms-transform: translate3d (-4px, 0, 0);
                transform: translate3d (-4px, 0, 0);
            }

            40%,
            60% {
                -webkit-transform: translate3d (4px, 0, 0);
                -ms-transform: translate3d (4px, 0, 0);
                transform: translate3d (4px, 0, 0);
            }
        }

        @keyframes gTcftA {

            10%,
            90% {
                -webkit-transform: translate3d(-1px, 0, 0);
                -ms-transform: translate3d(-1px, 0, 0);
                transform: translate3d(-1px, 0, 0);
            }

            20%,
            80% {
                -webkit-transform: translate3d (2px, 0, 0);
                -ms-transform: translate3d (2px, 0, 0);
                transform: translate3d (2px, 0, 0);
            }

            30%,
            50%,
            70% {
                -webkit-transform: translate3d(-4px, 0, 0);
                -ms-transform: translate3d(-4px, 0, 0);
                transform: translate3d (-4px, 0, 0);
            }

            40%,
            60% {
                -webkit-transform: translate3d(4px, 0, 0);
                -ms-transform: translate3d (4px, 0, 0);
                transform: translate3d (4px, 0, 0);
            }
        }

        /* sc-component-id: sc-keyframes-caPIRE */
        @-webkit-keyframes caPIRE {
            0% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }

            20% {
                -webkit-transform: scale(1);
                -ms-transform: scale(1);
                transform: scale(1);
            }

            40% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }

            60% {
                -webkit-transform: scale(1);
                -ms-transform: scale(1);
                transform: scale(1);
            }

            80% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }

            100% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }
        }

        @keyframes caPIRE {
            0% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }

            20% {
                -webkit-transform: scale(1);
                -ms-transform: scale(1);
                transform: scale(1);
            }

            40% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }

            60% {
                -webkit-transform: scale(1);
                -ms-transform: scale(1);
                transform: scale(1);
            }

            80% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }

            100% {
                -webkit-transform: scale(.75);
                -ms-transform: scale(.75);
                transform: scale(.75);
            }
        }
    </style>
    <style>
.glot-sub-active {
	color: #1296ba !important;
}

.glot-sub-hovered {
	color: #1296ba !important;
}

.glot-sub-clzz {
	cursor: pointer;
}

.glot-sub-clzz:hover {
	color: #1296ba !important;
}

.ej-trans-sub {
	position: absolute;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	z-index: 9999999;
	cursor: move;
}

.ej-trans-sub span {
	color: #3CF9ED;
	font-size: 18px;
	line-height: 1.5;
	background: rgba(32, 26, 25, 0.6);
	text-shadow: 0px 1px 4px black;
	padding: 0 8px;
}

.notfound {
	max-width: 767px;
	width: 100%;
	line-height: 1.4;
	padding: 0 25px
}

.notfound .notfound-404 {
	position: relative;
	height: 150px;
	line-height: 150px;
	margin-bottom: 40px
}

.notfound .notfound-404 h1 {
	font-family: titillium web, sans-serif;
	font-size: 186px;
	font-weight: 900;
	text-transform: uppercase;
	background-color: black;
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}
</style>
</head>
<body data-new-gr-c-s-check-loaded="14.1012.0" data-gr-ext-installed="">
    <div class="">
        <div class="page-container page-container-responsive">
            <div class="row space-top-8 space-8 row-table">
                <div class="col-5 col-middle">
                	<div class="notfound">
						<div class="notfound-404">
							<h1>404</h1>
						</div>
					</div>
					<h1 class="text-jumbo text-ginormous">THÔNG BÁO!</h1>
					<p>Trang này không tồn tại</p>
					<h6 id="back-to-home">
						Quay về <a href="#">trang chủ!</a>
					</h6>
				</div>
                <div class="col-5 col-middle text-center robo_figure">
                    <img class="robo_body" src="resources/ERROR/404_body.png" width="100%"
                        alt="Girl has dropped her ice cream."> <img src="resources/ERROR/404_bg.png"
                        width="100%" alt="Girl has dropped her ice cream.">
                    <div class="robo_shadow"></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>