const cityAreaMap = {
    "選擇縣市": ["選擇區域"],
    '基隆市': ['仁愛區', '信義區', '中正區', '中山區', '安樂區', '暖暖區', '七堵區'],
    '台北市': ["選擇區域", '中正區', '大同區', '中山區', '松山區', '大安區', '萬華區', '信義區', '士林區', '北投區', '內湖區', '南港區', '文山區'],
    '新北市': ["選擇區域", "板橋區", "三重區", "中和區", "永和區", "新莊區", "新店區", "土城區", "蘆洲區", " 樹林區", "汐止區", "鶯歌區", "三峽區", "淡水區", "瑞芳區", "五股區", "泰山區", "林口區", "深坑區", "石碇區", "坪林區", "三芝區", "石門區", "八里區", "平溪區", "雙溪區", "貢寮區", "金山區", "萬里區", "烏來區"],
    '宜蘭縣': ['宜蘭市', '頭城鎮', '礁溪鄉', '壯圍鄉', '員山鄉', '羅東鎮', '三星鄉', '大同鄉', '五結鄉',
        '冬山鄉', '蘇澳鎮', '南澳鄉', '釣魚臺列嶼'],
    '桃園市': ['中壢區', '平鎮區', '龍潭區', '楊梅區', '新屋區', '觀音區', '桃園區', '龜山區', '八德區',
        '大溪區', '復興區', '大園區', '蘆竹區'],

    '新竹市': ['東區', '北區', '香山區'],
    '新竹縣': ['竹北市', '湖口鄉', '新豐鄉', '新埔鎮', '關西鎮', '芎林鄉', '寶山鄉', '竹東鎮', '五峰鄉',
        '橫山鄉', '尖石鄉', '北埔鄉', '峨眉鄉'],
    '苗栗縣': ['竹南鎮', '頭份市', '三灣鄉', '南庄鄉', '獅潭鄉', '後龍鎮', '通霄鎮', '苑裡鎮', '苗栗市',
        '造橋鄉', '頭屋鄉', '公館鄉', '大湖鄉', '泰安鄉', '銅鑼鄉', '三義鄉', '西湖鄉', '卓蘭鎮'],
    '臺中市': ['中區', '東區', '南區', '西區', '北區', '北屯區', '西屯區', '南屯區', , '太平區', '大里區',
        '霧峰區', '烏日區', '豐原區', '后里區', '石岡區', '東勢區', '和平區', '新社區', '潭子區',
        '大雅區', '神岡區', '大肚區', '沙鹿區', '龍井區', '梧棲區', '清水區', '大甲區', '外埔區',
        '大安區'],
    '彰化縣': ['彰化市', '芬園鄉', '花壇鄉', '秀水鄉', '鹿港鎮', '福興鄉', '線西鄉', '和美鎮', '伸港鄉',
        '員林市', '社頭鄉', '永靖鄉', '埔心鄉', '溪湖鎮', '大村鄉', '埔鹽鄉', '田中鎮', '北斗鎮',
        '田尾鄉', '埤頭鄉', '溪州鄉', '竹塘鄉', '二林鎮', '大城鄉', '芳苑鄉', '二水鄉'],
    '南投縣': ['南投市', '中寮鄉', '草屯鎮', '國姓鄉', '埔里鎮', '仁愛鄉', '名間鄉', '集集鎮', '水里鄉',
        '魚池鄉', '信義鄉', '竹山鎮', '鹿谷鄉'],
    '嘉義市': ['東區', '西區'],
    '嘉義縣': ['番路鄉', '梅山鄉', '竹崎鄉', '阿里山鄉', '中埔鄉', '大埔鄉', '水上鄉', '鹿草鄉', '太保市',
        '朴子市', '東石鄉', '六腳鄉', '新港鄉', '民雄鄉', '大林鎮', '溪口鄉', '義竹鄉', '布袋鎮'],
    '雲林縣': ['斗南鎮', '大埤鄉', '虎尾鎮', '土庫鎮', '褒忠鄉', '東勢鄉', '臺西鄉', '崙背鄉', '麥寮鄉',
        '斗六市', '林內鄉', '古坑鄉', '莿桐鄉', '西螺鎮', '二崙鄉', '北港鎮', '水林鄉', '口湖鄉',
        '四湖鄉', '元長鄉'],
    '臺南市': ['中西區', '東區', '南區', '北區', '安平區', '安南區', '永康區', '歸仁區', '新化區',
        '左鎮區', '玉井區', '楠西區', '南化區', '仁德區', '關廟區', '龍崎區', '官田區', '麻豆區',
        '佳里區', '西港區', '七股區', '將軍區', '學甲區', '北門區', '新營區', '後壁區', '白河區',
        '東山區', '六甲區', '下營區', '柳營區', '鹽水區', '善化區', '大內區', '山上區', '新市區',
        '安定區'],
    '高雄市': ['新興區', '前金區', '苓雅區', '鹽埕區', '鼓山區', '旗津區', '前鎮區', '三民區', '楠梓區',
        '小港區', '左營區', '仁武區', '大社區', '東沙群島', '南沙群島', '岡山區', '路竹區', '阿蓮區',
        '田寮區', '燕巢區', '橋頭區', '梓官區', '彌陀區', '永安區', '湖內區', '鳳山區', '大寮區',
        '林園區', '鳥松區', '大樹區', '旗山區', '美濃區', '六龜區', '內門區', '杉林區', '甲仙區',
        '桃源區', '那瑪夏區', '茂林區', '茄萣區'],
    '屏東縣': ['屏東市', '三地門鄉', '霧臺鄉', '瑪家鄉', '九如鄉', '里港鄉', '高樹鄉', '鹽埔鄉',
        '長治鄉', '麟洛鄉', '竹田鄉', '內埔鄉', '萬丹鄉', '潮州鎮', '泰武鄉', '來義鄉',
        '萬巒鄉', '崁頂鄉', '新埤鄉', '南州鄉', '林邊鄉', '東港鎮', '琉球鄉', '佳冬鄉',
        '新園鄉', '枋寮鄉', '枋山鄉', '春日鄉', '獅子鄉', '車城鄉', '牡丹鄉', '恆春鎮',
        '滿州鄉'],
    '臺東縣': ['臺東市', '綠島鄉', '蘭嶼鄉', '延平鄉', '卑南鄉', '鹿野鄉', '關山鎮', '海端鄉', '池上鄉',
        '東河鄉', '成功鎮', '長濱鄉', '太麻里鄉', '金峰鄉', '大武鄉', '達仁鄉'],
    '花蓮縣': ['花蓮市', '新城鄉', '秀林鄉', '吉安鄉', '壽豐鄉', '鳳林鎮', '光復鄉', '豐濱鄉', '瑞穗鄉',
        '萬榮鄉', '玉里鎮', '卓溪鄉', '富里鄉'],
    '金門縣': ['金沙鎮', '金湖鎮', '金寧鄉', '金城鎮', '烈嶼鄉', '烏坵鄉'],
    '連江縣': ['南竿鄉', '北竿鄉', '莒光鄉', '東引鄉'],
    '澎湖縣': ['馬公市', '西嶼鄉', '望安鄉', '七美鄉', '白沙鄉', '湖西鄉']
};

const actTypeMap = {
    '1': '市集',
    '2': '展覽',
    '3': '表演'
};

const cities = {"基隆市":{"lat":25.12682, "lng":121.73787},
                        "台北市":{"lat":25.03746, "lng":121.564558},
                        "新北市":{"lat":25.01703, "lng":121.46281},
                        "宜蘭縣":{"lat":24.71253, "lng":121.75617},
                        "桃園市":{"lat":24.99724, "lng":121.30410},
                        "新竹市":{"lat":24.81340, "lng":120.96783},
                        "新竹縣":{"lat":24.84574, "lng":121.01627},
                        "苗栗縣":{"lat":24.56941, "lng":120.81255},
                        "臺中市":{"lat":24.12848, "lng":120.63690},
                        "彰化縣":{"lat":24.05806, "lng":120.49739},
                        "南投縣":{"lat":23.91712, "lng":120.67326},
                        "嘉義市":{"lat":23.47925, "lng":120.45547},
                        "嘉義縣":{"lat":23.45022, "lng":120.26279},
                        "雲林縣":{"lat":23.70793, "lng":120.43313},
                        "臺南市":{"lat":23.00556, "lng":120.24107},
                        "高雄市":{"lat":22.65416, "lng":120.49920},
                        "屏東縣":{"lat":22.67502, "lng":120.49392},
                        "臺東縣":{"lat":22.80530, "lng":121.06613},
                        "花蓮縣":{"lat":23.99861, "lng":121.56880},
                        "金門縣":{"lat":24.43991, "lng":118.37197},
                        "連江縣":{"lat":26.16409, "lng":119.94968},
                        "澎湖縣":{"lat":23.57268, "lng":119.57196},
                        "選擇縣市":{lat: 23.765817745586514, lng: 120.96836965792725},
};

const areas = {
	"中正區":{"lat":25.032361,"lng":121.518267},
    "大同區":{"lat":25.06320,"lng":121.51154},
    "中山區":{"lat":25.07925,"lng":121.54223},
                       "松山區":{"lat":25.05469,"lng":121.56470},
                       "大安區":{"lat":25.02529,"lng":121.54470},
                       "萬華區":{"lat":25.02661,"lng":121.49651},
                       "信義區":{"lat":25.04115,"lng":121.571370},
                       "士林區":{"lat":25.09637,"lng":121.52495},
                       "北投區":{"lat":25.11644,"lng":121.51505},
                       "內湖區":{"lat":25.06873,"lng":121.59123},
                       "南港區":{"lat":25.03108,"lng":121.61152},
                       "文山區":{"lat":24.98831,"lng":121.55982},

                       "板橋區":{"lat":25.01153,"lng":121.46311}, 
                       "三重區":{"lat":25.06149,"lng":121.48745}, 
                       "中和區":{"lat":24.99674,"lng":121.48286}, 
                       "永和區":{"lat":25.01151,"lng":121.51479}, 
                       "新莊區":{"lat":25.02606,"lng":121.41848}, 
                       "新店區":{"lat":24.97848,"lng":121.54255}, 
                       "土城區":{"lat":24.96914,"lng":121.43680}, 
                       "蘆洲區":{"lat":25.08766,"lng":121.47045}, 
                       "樹林區":{"lat":24.98172,"lng":121.42073}, 
                       "汐止區":{"lat":25.06215,"lng":121.63970},
                       "鶯歌區":{"lat":24.96249,"lng":121.34011}, 
                       "三峽區":{"lat":24.93646,"lng":121.36848}, 
                       "淡水區":{"lat":25.17230,"lng":121.44356}, 
                       "瑞芳區":{"lat":25.10435,"lng":121.82203}, 
                       "五股區":{"lat":25.08642,"lng":121.44092}, 
                       "泰山區":{"lat":25.05786,"lng":121.43365}, 
                       "林口區":{"lat":25.08051,"lng":121.38867}, 
                       "深坑區":{"lat":25.00242,"lng":121.61571}, 
                       "石碇區":{"lat":25.01024,"lng":121.64275}, 
                       "坪林區":{"lat":24.93641,"lng":121.71390}, 
                       "三芝區":{"lat":25.26036,"lng":121.50187}, 
                       "石門區":{"lat":25.29128,"lng":121.56440}, 
                       "八里區":{"lat":25.14686,"lng":121.40182}, 
                       "平溪區":{"lat":25.02629,"lng":121.73423}, 
                       "雙溪區":{"lat":24.99780,"lng":121.82012}, 
                       "貢寮區":{"lat":25.01664,"lng":121.94269}, 
                       "金山區":{"lat":25.22369,"lng":121.63636}, 
                       "萬里區":{"lat":25.16901,"lng":121.63568}, 
                       "烏來區":{"lat":24.86764,"lng":121.55044}
};



let map;
let activities;
const markers = [];

window.initMap = initMap;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 7.5,
        center: { lat: 23.765817745586514, lng: 120.96836965792725 },
    });

    fetch('../map')
        .then(resp => resp.json())
        .then(activityList => {
            activities = activityList;
            addMarkers();
        });
}

function addMarkers() {
    for (let activity of activities) {
        addMarker(activity);
    }
}

function addMarker(activity) {
    const marker = getMarker(activity);
    const infoWindow = getInfoWindow(activity);

    marker.addListener('click', () => {
        infoWindow.open({
            anchor: marker,
            map
        });
    });

    markers.push(marker);

    function getMarker({ actLatitude, actLongitude, actCity, actZone, actType, actName, actAddress }) {
        return new google.maps.Marker({
            map,
            position: {
                lat: actLatitude,
                lng: actLongitude
            },
            actCity,
            actZone,
            actType,
            actName,
            actAddress
        });
    }

    function getInfoWindow({ actCoverPicture, actName, actStartDate, actEndDate, actAddress, actId, actType, actViews, actLikeTimes }) {
        const htmlTemplate = `
            <div class="card col-3 clickable-card" data-actid="10001" style=" padding:0px; margin: 10px 5px; width:250px;">
                <img src="${bytesToUrl(actCoverPicture)}" class="card-img top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${actName}</h5>
                    <h5 style="font-size: 12px;">${actStartDate}~${actEndDate}</h5>
                    <h5 style="font-size: 12px;">${actAddress}</h5>
                    <button type="button" class="btn btn-secondary btn-sm" onclick="location = '../SingleActivity.html?actId=${actId}'">${actTypeMap[actType]}</button>
                    <span style="font-size: 12px;">觀看次數:${actViews}</span>
                    <span style="font-size: 12px;">按讚次數:${actLikeTimes}</span>
                </div>
            </div>`;
        return new google.maps.InfoWindow({
            content: htmlTemplate,
            ariaLabel: activity.actId,
        });
    }
}

function bytesToUrl(actCoverPicture) {
    const int8Array = new Int8Array(actCoverPicture);
    const blob = new Blob([int8Array]);
    return URL.createObjectURL(blob);
}
const citySelect = document.querySelector('#citySelect');
const areaSelect = document.querySelector('#areaSelect');
const activitySelect = document.querySelector('#activitySelect');
const searchInput = document.querySelector('#searchInput');

citySelect.addEventListener('change', e => {
    const city = e.target.value;
    const type = +activitySelect.value;
    const text = searchInput.value;
    markers.forEach(marker => {
        const condition1 = city === '選擇縣市' ? true : marker.actCity === city;
        const condition3 = type === 0 ? true : marker.actType === type;
        const condition4 = !text ? true : marker.actName.includes(text) || marker.actAddress.includes(text)
        marker.setVisible(condition1 && condition3 && condition4);
    });
    setAreaSelect(city);
    
    movMap(cities[city], city === '選擇縣市' ? 7.5 : 10);
});

function setAreaSelect(city) {
    areaSelect.innerHTML = '';
    for (let area of cityAreaMap[city]) {
        areaSelect.innerHTML += `<option>${area}</option>`;
    }
}

areaSelect.addEventListener('change', e => {
    const zone = e.target.value;
    const city = citySelect.value;
    const type = +activitySelect.value;
    const text = searchInput.value;
    markers.forEach(marker => {
        const condition1 = city === '選擇縣市' ? true : marker.actCity === city;
        const condition2 = zone === '選擇區域' ? true : marker.actZone === zone;
        const condition3 = type === 0 ? true : marker.actType === type;
        const condition4 = !text ? true : marker.actName.includes(text) || marker.actAddress.includes(text)
        marker.setVisible(condition1 && condition2 && condition3 && condition4);
    });
    
    if (zone === '選擇區域') {
		movMap(cities[city], city === '選擇縣市' ? 7.5 : 10);	
	} else {
		movMap(areas[zone], 12.5);	
	}
});

activitySelect.addEventListener('change', e => {
    const type = +e.target.value;
    const city = citySelect.value;
    const zone = areaSelect.value;
    const text = searchInput.value;
    markers.forEach(marker => {
        const condition1 = city === '選擇縣市' ? true : marker.actCity === city;
        const condition2 = zone === '選擇區域' ? true : marker.actZone === zone;
        const condition3 = type === 0 ? true : marker.actType === type;
        const condition4 = !text ? true : marker.actName.includes(text) || marker.actAddress.includes(text)
        marker.setVisible(condition1 && condition2 && condition3 && condition4);
    });
});

searchInput.addEventListener('input', e => {
    const text = e.target.value;
    const city = citySelect.value;
    const zone = areaSelect.value;
    const type = +activitySelect.value;
    markers.forEach(marker => {
        const condition1 = city === '選擇縣市' ? true : marker.actCity === city;
        const condition2 = zone === '選擇區域' ? true : marker.actZone === zone;
        const condition3 = type === 0 ? true : marker.actType === type;
        const condition4 = !text ? true : marker.actName.includes(text) || marker.actAddress.includes(text)
        marker.setVisible(condition1 && condition2 && condition3 && condition4);
    });
});

function movMap(latLng, zoom) {
	if (map) {
		map.setCenter(latLng);
		map.setZoom(zoom);
	}
}