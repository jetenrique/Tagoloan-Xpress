const assetPathPrefix = "https://www.figma.com/api/mcp/asset/8a26ee92-fdc1-40fe-94bc-d56a865900f8";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconBag = `${assetPathPrefix}/2f607.svg`;
const imgIconPhone = `${assetPathPrefix}/eede5.svg`;
const imgIconEye = `${assetPathPrefix}/eca05.svg`;

export default function CustomerLoginView() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:45" data-name="customer-login-view">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="124:3" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="124:4" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="124:5" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="124:6">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="124:7" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="124:8" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="124:10" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="124:12" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="124:14" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="124:15" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="124:16" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="flex-[1_0_0] h-[100px] min-w-px relative" data-node-id="124:18" data-name="Container" />
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[20px] items-start min-h-px overflow-clip px-[24px] py-[16px] relative w-full" data-node-id="124:20" data-name="Body">
          <div className="content-stretch flex flex-col gap-[8px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:21" data-name="Intro">
            <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[16px] shrink-0 size-[56px]" data-node-id="124:22" data-name="Container">
              <div className="relative shrink-0 size-[26px]" data-node-id="124:23" data-name="icon/bag">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBag} />
              </div>
            </div>
            <div className="h-[4px] relative shrink-0 w-full" data-node-id="124:26" data-name="Spacer" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[24px] w-[min-content]" data-node-id="124:27">
              Welcome back
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[14px] w-[min-content]" data-node-id="124:28">
              Log in to request errands and deliveries in Tagoloan.
            </p>
          </div>
          <div className="h-[4px] relative shrink-0 w-full" data-node-id="124:29" data-name="Spacer" />
          <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:30" data-name="Field – Mobile number or email">
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:31" data-name="Container">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-px relative text-[#18181f] text-[13px]" data-node-id="124:32">
                Mobile number or email
              </p>
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[10px] h-[48px] items-center overflow-clip px-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="124:33" data-name="Input">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#a3a3ab] text-[15px]" data-node-id="124:34">
                09XX XXX XXXX
              </p>
              <div className="relative shrink-0 size-[18px]" data-node-id="124:35" data-name="icon/phone">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconPhone} />
              </div>
            </div>
          </div>
          <div className="content-stretch flex flex-col gap-[6px] items-start overflow-clip relative shrink-0 w-full" data-node-id="124:38" data-name="Field – Password">
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="124:39" data-name="Container">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] min-w-px relative text-[#18181f] text-[13px]" data-node-id="124:40">
                Password
              </p>
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[10px] h-[48px] items-center overflow-clip px-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="124:41" data-name="Input">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#18181f] text-[15px]" data-node-id="124:42">
                ••••••••
              </p>
              <div className="relative shrink-0 size-[18px]" data-node-id="124:43" data-name="icon/eye">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconEye} />
              </div>
            </div>
          </div>
          <div className="content-stretch flex items-start justify-end overflow-clip relative shrink-0 w-full" data-node-id="124:46" data-name="Container">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[13px] whitespace-nowrap" data-node-id="124:47">
              Forgot password?
            </p>
          </div>
          <a className="bg-[#febc20] content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="124:48" data-name="Button – Log in">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="124:49">
              Log in
            </p>
          </a>
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="124:51" data-name="Flexible space" />
          <div className="content-stretch flex flex-col gap-[10px] items-center overflow-clip relative shrink-0 w-full" data-node-id="124:52" data-name="Register">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] relative shrink-0 text-[#6b6b73] text-[13px] whitespace-nowrap" data-node-id="124:53">{`Don't have an account?`}</p>
            <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[13px] relative rounded-[14px] shrink-0 w-full" data-node-id="124:54" data-name="Button – Create an account">
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="124:55">
                Create an account
              </p>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}
