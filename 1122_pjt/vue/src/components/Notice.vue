 <template>
	<div>
	<h2 style="text-align: center;" >공지사항&nbsp;&nbsp;&nbsp;&nbsp;</h2>
	<br>
	<div class="container" style="width: 50%;">
		<table class="table table-striped">
			<tr>
				<th style="width: 10px; text-align: center;">NO</th>
				<th style="width: 200px; text-align: center;">제 목</th>
				<th style="width: 30px; text-align: center;">게시일</th>
			</tr>
			<c:forEach var="nlist" items="${noticelist}">
			<tr>
				<td style="text-align: center;">${nlist.bno}</td>
				<td style="text-align: center;"><a href="#">${nlist.title}</a></td>
				<td style="text-align: center;"><fmt:formatDate value="${nlist.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			</c:forEach>
		</table>
		<a class="btn btn-group btn-default btn-animated pull-right"
			onclick="goBoardReg()">글쓰기</a>

	</div>

	</div>
	

</template>

<script>
// 위에서 추가했던 jQuery 밑에 코드를 작성하세요


import 'http'
import http from "../http-common";
export default {
    name: "MainList",
  data() {
    return {
      upHere: false,
      info: [],
      loading: true,
      errored: false
    };
  },
    methods:{
        getMainList(){
            http
              .get("localhost:8090/list")
              .then(response => (this.info = response.list))
              .catch(()=>{
                  this.errored = true;
              })
        },
        getImg(pic){
          return require('../assets/'+pic)
        }
    }

//   mounted(){
//       http
//               .get("http://localhost:8090/api/food/list/%20")
//               .then(response => (this.info = response.data.list))
//               .catch(()=>{
//                   this.errored = true;
//               });
//   }


}
</script>