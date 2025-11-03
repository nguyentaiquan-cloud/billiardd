# Lập trình song song - Bài toán Bi-a

Mô tả ngắn gọn:
Bài làm mô phỏng bài toán bi-a ở chế độ song song, theo nội dung từ slide ảnh. Mục tiêu là xây dựng một mô hình cho các quả bóng nảy, va chạm và tăng dần số bóng.

## Yêu cầu và nội dung bài làm
1. Vẽ đồ họa mô tả 1 quả bóng nảy trong khung hình chữ nhật (giống bi-a).
2. Nhân bản 8 quả bóng và với 8 màu khác nhau, cùng lúc chuyển động với góc ngẫu nhiên. Chỉ cần va chạm và không va chạm vào nhau.
3. Cho phép quả bóng va chạm và tương tác; tối ưu tốc độ, tạm dừng sau 1 phút.
4. Nhập dữ liệu hoặc tham chiếu vào cho từng quả bóng.
5. 1 điều lệ ở giữa bàn, quả nào rơi xuống lỗ thì biến mất.
6. Cải tiến theo hướng tăng số bóng lên 200 quả và tối ưu hóa hiệu suất.
7. Xây dựng 3 map khác nhau: 3 chế độ hoặc bố cục khác nhau, tạo điểm xuất phát và dự đoán quả nào rơi xuống lỗ.

Kết thúc: Đẩy mã nguồn lên GitHub, mô tả bằng tiếng Anh cho người dùng nước ngoài.

## Cài đặt và chạy
Yêu cầu: Python 3.8+

1) Tạo môi trường và cài đặt:
```bash  
python -m venv venv  
source venv/bin/activate   # Linux/macOS  
venv\Scripts\activate      # Windows  
pip install -r requirements.txt  
