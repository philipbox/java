<template>
    <div class="container" style="width: 50%;">
		<table class="table table-striped">
      <thead>
			<tr>
				<th style="width: 10px; text-align: center;">NO</th>
				<th style="width: 200px; text-align: center;">제 목</th>
				<th style="width: 30px; text-align: center;">게시일</th>
				<th style="width: 30px; text-align: center;">조회수</th>
			</tr>
			</thead>
      <tbody>
			<tr v-for="nlist in noticelist" :key="nlist" >
				<td style="text-align: center;">{{nlist.bno}}</td>
				<td style="text-align: center;"><a v-on:click="goNoticeView(nlist.bno)" >{{nlist.title}}</a></td>
        <td style="text-align: center;">{{nlist.regdate}}</td>
        <td style="text-align: center;">{{nlist.viewcnt}}</td>
			</tr>
      </tbody>
		</table>
		<a class="btn btn-group btn-default btn-animated pull-right"
			v-on:click="goBoardReg()">글쓰기</a>

	</div>


</template>



<script>

import 'http'
import http from "../http-common";


export default {
    name: "NoticeList",
    props: ["code"],
  data() {
    return {
      
      upHere: false,
      noticelist: null,
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
        },
        getNotice: function() {            
            http
                  .get("http://localhost:8090/api/notice/noticelist")
                  .then(response => (this.noticelist = response.data.resValue))
                  .catch(()=>{
                      this.errored = true;

                    })
            //alert(this.code);
        },
        goNoticeView(no){            
          this.$router.push("/noticeview/" + no);
          return;
        },
        goBoardReg(){         
          alert("공지사항 글쓰기")   
          this.$router.push("/noticereg/");
          return;
        }
    },

  mounted(){
    this.getNotice();
      
  }


}
</script>