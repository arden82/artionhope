<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Google Maps Page</title>
    <style>
        /* 设置地图容器的大小 */
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
</head>
<body>
    <h1>Google Maps Example</h1>
    <div id="map"></div>

    <script>
        // 使用你的 Google Maps API 密钥初始化地图
        function initMap() {
            // 创建一个新的地图实例
            var map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: 40.7128, lng: -74.0060}, // 设置地图中心点坐标
                zoom: 12 // 设置初始缩放级别
            });
            
            // 创建一个标记
            var marker = new google.maps.Marker({
                position: {lat: 40.7128, lng: -74.0060}, // 设置标记的坐标
                map: map, // 关联标记与地图
                title: 'New York City' // 设置标记的标题
            });
        }
    </script>

    <!-- 加载 Google Maps JavaScript API，并使用你的 API 密钥 -->
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>
</body>
</html>
