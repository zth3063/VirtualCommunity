// 获取表单元素
const form = document.querySelector('form');

// 为表单添加提交事件监听器
form.addEventListener('submit', function (event) {
    event.preventDefault();
    const userName = document.querySelector('input[type="text"]').value;
    const password = document.querySelector('input[type="password"]').value;
    // 使用 AJAX 发送请求到后端进行登录验证
    fetch('http://localhost:8888/userLogin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ userName: userName, password: password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.code === 500) {
                alert('登录成功！');
                // 可以在这里进行页面跳转或其他操作
            } else {
                alert('登录失败：' + data.message);
            }
        })
        .catch(error => {
            console.error('发生错误：', error);
            alert('发生错误：' + error.message);
        });
});
