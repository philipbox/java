<template>
    <div>
        <h2 style="text-align: center;">공지사항 작성</h2>
        <div class="container" style="width: 40%;">
		<form role="form" id="register"  method="post" action="noticereg" @submit.prevent="noticereg">
		<table class="table table-striped">
		<tbody>	
            <tr>
				<th style="text-align: center;">제 목</th>
			</tr>
			<tr>
				<td>
				<input type="text" name="btitle" style="width:720px" required="required" v-model="notice.title">
				</td>
			</tr>
			<tr>
				<th style="text-align: center;">내 용</th>
			</tr>
			<tr>
				<td><textarea name="bcontent" rows="15" cols="100" required="required" v-model="notice.content"></textarea></td>
			</tr>
			<tr>
			</tr>
        </tbody>
		</table>
		<button type="submit" class="btn btn-primary btn-block pull-right" style="width:70px;">등 록</button>
		</form>
		<br><br><br><br>
	</div>
    </div>
    
</template>



<script>
import 'http'
import http from "../http-common";
export default {
    name: "noticereg",
  data() {
    return {
        notice:{
            title : '',
            content : ''
        },
        submitted : false
    };
  },
    methods:{
        noticereg() {
            alert(this.notice.title);
            alert(this.notice.content);
            http.post('/notice/insert', {
                title : this.notice.title,
                content : this.notice.content
            }).then(response => {
                alert(response.data.resMsg);
                this.$router.push("/noticelist");
            }).catch(() => {
                alert("등록을 하지 못했습니다.");
            })
        }
    }
}
</script>