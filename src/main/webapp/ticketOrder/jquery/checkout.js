
// $(document).ready(function () {
//     $("#button-addon2").click(function () {
//         $("#coupon").slideToggle();
//     });
// });

$(document).ready(function () {
    // 初始化購物車
    var cart = [];
  
    // 更新購物車中的商品列表
    function updateCart() {
      var cartTable = $('.site-block-order-table tbody');
      cartTable.empty();
  
      var totalPrice = 0;
  
      cart.forEach(function (item) {
        var row = '<tr>' +
          '<td>' + item.name + ' <strong class="mx-2">x</strong> ' + item.quantity + '</td>' +
          '<td>$' + (item.price * item.quantity) + '</td>' +
          '</tr>';
  
        cartTable.append(row);
  
        totalPrice += item.price * item.quantity;
      });
  
      // 更新商品金額
      $('.site-block-order-table tbody').append(
        '<tr>' +
        '<td class="text-black font-weight-bold"><strong>商品金額</strong></td>' +
        '<td class="text-black">$' + totalPrice + '</td>' +
        '</tr>'
      );
  
      // 更新實付金額
      var discountAmount = 200; // 假設有$200的折扣
      var finalPrice = totalPrice - discountAmount;
      $('.site-block-order-table tbody').append(
        '<tr>' +
        '<td class="text-black font-weight-bold"><strong>折扣金額</strong></td>' +
        '<td class="text-black">$' + discountAmount + '</td>' +
        '</tr>'
      );
  
      $('.site-block-order-table tbody').append(
        '<tr>' +
        '<td class="text-black font-weight-bold"><strong>實付金額</strong></td>' +
        '<td class="text-black font-weight-bold"><strong>$' + finalPrice + '</strong></td>' +
        '</tr>'
      );
    }
  
    // 當按下增加按鈕時
    $('.increase').click(function () {
      var productName = $(this).closest('tr').find('td:first').text().split('x')[0].trim();
      var productPrice = parseInt($(this).closest('tr').find('td:last').text().replace('$', '').trim());
  
      var existingItem = cart.find(function (item) {
        return item.name === productName;
      });
  
      if (existingItem) {
        existingItem.quantity++;
      } else {
        cart.push({ name: productName, price: productPrice, quantity: 1 });
      }
  
      updateCart();
    });
  
    // 當按下使用折扣碼按鈕時
    $('#button-addon2').click(function () {
      // 在這裡處理折扣碼的檢查和應用
      // 您可以獲取輸入框中的折扣碼，然後更新折扣金額和實付金額
      // 這裡假設有$200的折扣
      updateCart();
    });
  
    // 當按下下訂單按鈕時
    $('.btn_checkorder').click(function () {
      // 在這裡處理下訂單的相關操作
      // 可能需要向伺服器發送資料，完成訂單處理等
      // 這裡示範跳轉至感謝頁面
      window.location = 'thankyou.html';
    });
  });/**
 * 
 */