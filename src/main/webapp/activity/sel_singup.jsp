<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

    <style>
        .custom-form-container {
            max-width: 800px;
            /* 调整这个值以改变表单的宽度 */
            margin: 0 auto;
            /* 水平居中 */
        }
    </style>
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner"
            class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Form Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4 justify-content-center">
                <!-- 左侧卡片区块，占据6列，即半屏宽度 -->
                <div class="col-sm-6 col-xl-4 ml-auto">
                    <div class="bg-light rounded h-100 p-4">
                        <h6 class="mb-4" style="font-size: 24px; color:#009CFF">廠商註冊</h6>
                        <div class="mb-3">
                            <label for="sellEmail" class="form-label">Email</label>
                            <input type="email" class="form-control" id="sellName" value="將以此 E-mail為登入、驗證用">
                        </div>
                        <div class="row">
                            <div class="mb-3">
                                <label for="sellpassword" class="form-label">密碼</label>
                                <input type="text" class="form-control" id="sellName" value="至少7個字元，須包含英文或數字">
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="sellName" class="form-label">廠商名稱</label>
                            <input type="text" class="form-control" id="sellName" value="">
                        </div>
                        <div class="mb-3">
                            <label for="sellPhoneNumber" class="form-label">電話</label>
                            <input type="text" class="form-control" id="sellPhoneNumber" value="">
                        </div>
                    </div>
                </div>

                <!-- 右侧卡片区块，占据6列，即半屏宽度 -->

                <div class="col-sm-6 col-xl-4 mr-auto">
                    <div class="bg-light rounded h-100 p-4">
                        <div class="mb-3">
                            <label for="sellAddress" class="form-label" style="margin-top: 55px;">廠商地址</label>
                            <input type="text" class="form-control" id="sellAddress" value="">
                        </div>
                        <div class="mb-3">
                            <label for="sellAddress" class="form-label">官方網址</label>
                            <input type="text" class="form-control" id="sellAddress" value="">
                        </div>
                        <div class="mb-3">
                            <label for="sellAddress" class="form-label">Facebook</label>
                            <input type="text" class="form-control" id="sellAddress"
                                value="">
                        </div>
                        <div class="mb-3">
                            <label for="sellAddress" class="form-label">單位連絡人</label>
                            <input type="text" class="form-control" id="sellAddress" value="">
                        </div>
                    </div>
                </div>
            </div>

            <!-- 分隔線 -->
            <div class="col-sm-12 col-xl-12 mt-4"></div>

            <!-- 下方區塊 廠商簡介-->
            <div class="row g-4 justify-content-center">
                <div class="col-sm-8">
                    <div class="bg-light rounded h-100 p-4">
                        <div class="col">
                            <div class="mb-3">
                                <label for="sellIntroduction" class="form-label">廠商簡介</label>
                                <textarea class="form-control" id="sellIntroduction"
                                    style="width: 100%; max-width: 
                                        910px; min-height: 200px; box-sizing: border-box;"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 分隔線 -->
            <div class="col-sm-12 col-xl-12 mt-2"></div>

            <!-- 下方區塊 帳務資訊-->

            <div class="container-fluid pt-4 px-4">
                <div class="custom-form-container bg-light rounded h-100 p-4">
                    <div class="row">
                        <div class="col">
                            <div class="mb-2">
                                <div class="form-group">
                                    <label for="bankCode" class="form-label">銀行代碼</label>
                                    <div class="d-flex">
                                        <input type="text" class="form-control" id="bankCode" value="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="mb-3">
                                <label for="bankAccount" class="form-label">銀行帳號</label>
                                <div class="d-flex">
                                    <input type="text" class="form-control" id="bankAccount" value="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="mb-2">
                                <div class="form-group">
                                    <label for="accountNAme" class="form-label">戶名</label>
                                    <div class="d-flex">
                                        <input type="text" class="form-control" id="accountNAme" value="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="mb-3">
                                <label for="remark" class="form-label">備註</label>
                                <div class="d-flex">
                                    <input type="text" class="form-control" id="remark" value="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 分隔線 -->
                <div class="col-sm-12 col-xl-12 mt-4"></div>

                <!-- 下方區塊 單位資料-->
                <div class="container-fluid pt-4 px-4">
                    <div class="custom-form-container bg-light rounded h-100 p-4">
                        <div class="row">
                            <div class="col">
                                <div class="mb-2">
                                    <div class="form-group">
                                        <label for="departmentName" class="form-label">單位名稱</label>
                                        <div class="d-flex">
                                            <input type="text" class="form-control" id="departmentName" value="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="mb-3">
                                    <label for="departmenBoss" class="form-label">單位負責人</label>
                                    <div class="d-flex">
                                        <input type="text" class="form-control" id="departmenBoss" value="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="mb-2">
                                    <div class="form-group">
                                        <label for="guiNumber" class="form-label">統一編號</label>
                                        <div class="d-flex">
                                            <input type="text" class="form-control" id="guiNumber" value="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="mb-3">
                                    <label for="registeredAddress" class="form-label">單位立案地址</label>
                                    <div class="d-flex">
                                        <input type="text" class="form-control" id="registeredAddress" value="
                                                ">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="text-center" style="margin-top: 30px;"> <!-- 文本置中並設定上邊距 -->
                            <button type="button" class="btn btn-outline-secondary m-2">修改</button>
                            <button type="button" class="btn btn-outline-secondary m-2">儲存</button>
                            <button type="button" class="btn btn-outline-secondary m-2">送出</button>
                        </div>
                    </div>
           
                    <!-- Form End -->
                </div>

                <!-- JavaScript Libraries -->
                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
                <script src="lib/chart/chart.min.js"></script>
                <script src="lib/easing/easing.min.js"></script>
                <script src="lib/waypoints/waypoints.min.js"></script>
                <script src="lib/owlcarousel/owl.carousel.min.js"></script>
                <script src="lib/tempusdominus/js/moment.min.js"></script>
                <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
                <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

                <!-- Template Javascript -->
                <script src="js/main.js"></script>
</body>

</html>