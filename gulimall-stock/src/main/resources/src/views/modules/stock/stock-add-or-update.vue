<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="stockcode">
      <el-input v-model="dataForm.stockcode" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="stockname">
      <el-input v-model="dataForm.stockname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="industry">
      <el-input v-model="dataForm.industry" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason1">
      <el-input v-model="dataForm.reason1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason2">
      <el-input v-model="dataForm.reason2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason3">
      <el-input v-model="dataForm.reason3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason4">
      <el-input v-model="dataForm.reason4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason5">
      <el-input v-model="dataForm.reason5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason6">
      <el-input v-model="dataForm.reason6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason7">
      <el-input v-model="dataForm.reason7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason8">
      <el-input v-model="dataForm.reason8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason9">
      <el-input v-model="dataForm.reason9" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason10">
      <el-input v-model="dataForm.reason10" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason11">
      <el-input v-model="dataForm.reason11" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason12">
      <el-input v-model="dataForm.reason12" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason13">
      <el-input v-model="dataForm.reason13" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason14">
      <el-input v-model="dataForm.reason14" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason15">
      <el-input v-model="dataForm.reason15" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          stockcode: '',
          stockname: '',
          industry: '',
          reason1: '',
          reason2: '',
          reason3: '',
          reason4: '',
          reason5: '',
          reason6: '',
          reason7: '',
          reason8: '',
          reason9: '',
          reason10: '',
          reason11: '',
          reason12: '',
          reason13: '',
          reason14: '',
          reason15: ''
        },
        dataRule: {
          stockcode: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          stockname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          industry: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason9: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason10: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason11: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason12: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason13: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason14: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason15: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/stock/stock/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.stockcode = data.stock.stockcode
                this.dataForm.stockname = data.stock.stockname
                this.dataForm.industry = data.stock.industry
                this.dataForm.reason1 = data.stock.reason1
                this.dataForm.reason2 = data.stock.reason2
                this.dataForm.reason3 = data.stock.reason3
                this.dataForm.reason4 = data.stock.reason4
                this.dataForm.reason5 = data.stock.reason5
                this.dataForm.reason6 = data.stock.reason6
                this.dataForm.reason7 = data.stock.reason7
                this.dataForm.reason8 = data.stock.reason8
                this.dataForm.reason9 = data.stock.reason9
                this.dataForm.reason10 = data.stock.reason10
                this.dataForm.reason11 = data.stock.reason11
                this.dataForm.reason12 = data.stock.reason12
                this.dataForm.reason13 = data.stock.reason13
                this.dataForm.reason14 = data.stock.reason14
                this.dataForm.reason15 = data.stock.reason15
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/stock/stock/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'stockcode': this.dataForm.stockcode,
                'stockname': this.dataForm.stockname,
                'industry': this.dataForm.industry,
                'reason1': this.dataForm.reason1,
                'reason2': this.dataForm.reason2,
                'reason3': this.dataForm.reason3,
                'reason4': this.dataForm.reason4,
                'reason5': this.dataForm.reason5,
                'reason6': this.dataForm.reason6,
                'reason7': this.dataForm.reason7,
                'reason8': this.dataForm.reason8,
                'reason9': this.dataForm.reason9,
                'reason10': this.dataForm.reason10,
                'reason11': this.dataForm.reason11,
                'reason12': this.dataForm.reason12,
                'reason13': this.dataForm.reason13,
                'reason14': this.dataForm.reason14,
                'reason15': this.dataForm.reason15
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
